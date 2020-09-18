package com.distarise.base.adapters;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.action.LoginAction;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.WidgetDto;
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
        String clientId="";
        String module;
        String redirectPage;
        HttpSession session = httpServletRequest.getSession();
        String[] url = httpServletRequest.getRequestURI().split("/");
        if (url.length == 4) {
            clientId = url[1];
            module = url[2];
            redirectPage = url[3];
        }
        if (null == session.getAttribute(UserService.USER)){
            userDetailsDto = userService.getUserDetails(GUEST_USER, GUEST_USER,
                    clientId);
            session.setAttribute(UserService.USER, userDetailsDto);
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
