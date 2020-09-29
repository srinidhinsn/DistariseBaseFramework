package com.distarise.base.adapters;

import com.distarise.base.action.BaseAction;
import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.service.AbstractBaseService;
import com.distarise.base.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Component
public class FrameworkInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(FrameworkInterceptor.class);
    private final String GUEST_USER = "guest";

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.debug("preHandle-"+httpServletRequest.getRequestURI());
        UserDetailsDto userDetailsDto = null;
        BaseContextDto baseContextDto = null;
        String clientId;
        String module;
        String redirectPage;
        HttpSession session = httpServletRequest.getSession();
        String[] url = httpServletRequest.getRequestURI().split("/");
        logger.debug("URL[]-"+ Arrays.toString(url));

        if (url.length >= 3) {
            redirectPage = url[url.length-1];
            module = url[url.length-2];
            clientId = url[url.length-3];
            if (null == session.getAttribute(AbstractBaseService.BASE_CONTEXT)){
                logger.debug("Base context is null. Creating base context");
                userDetailsDto = userService.getUserDetails(GUEST_USER, GUEST_USER,
                        clientId);
                baseContextDto = new BaseContextDto(clientId, module, redirectPage, userDetailsDto);
                session.setAttribute(AbstractBaseService.BASE_CONTEXT, baseContextDto);
            } else {
                baseContextDto = (BaseContextDto) session.getAttribute(AbstractBaseService.BASE_CONTEXT);
                baseContextDto.setModule(module);
                baseContextDto.setPageName(redirectPage);
                baseContextDto.setClientId(clientId);
                logger.debug("Base context found: Client-"+baseContextDto.getClientId()+
                        "Module-"+baseContextDto.getModule()+"Page-"+baseContextDto.getPageName());
                session.setAttribute(AbstractBaseService.BASE_CONTEXT, baseContextDto);
            }
        }else {
            logger.debug("URL does not contains required arguments");
        }

        if (null != httpServletRequest.getParameter("action")) {
            try {
                Class actionClass = Class.forName(httpServletRequest.getParameter("action"));
                BaseAction abstractBaseAction = (BaseAction) applicationContext.getBean(actionClass);
                abstractBaseAction.executeAction(httpServletRequest);
                abstractBaseAction.executeAction();
            }catch (ClassNotFoundException cnf){
                logger.error(cnf.getMessage());
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.debug("postHandle-"+httpServletRequest.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.debug("afterCompletion-"+httpServletRequest.getRequestURI());
    }

}
