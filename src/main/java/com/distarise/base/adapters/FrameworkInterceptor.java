package com.distarise.base.adapters;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.action.LoginAction;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.RoleWidgetActionDto;
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
import java.io.IOException;

@Component
public class FrameworkInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(FrameworkInterceptor.class);

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.debug("preHandle-"+httpServletRequest.getRequestURI());
        String actionIdentifier = httpServletRequest.getParameter("actionIdentifier");
        if (null != httpServletRequest.getParameter("action") &&
                !httpServletRequest.getParameter("action").isEmpty()) {
            try {
                String widgetId = actionIdentifier.split("-")[2];
                Class actionClass = Class.forName(httpServletRequest.getParameter("action"));
                UserDetailsDto userDetailsDto = (UserDetailsDto) httpServletRequest.getSession().getAttribute(UserService.USER);
                RoleWidgetActionDto accessExists = userDetailsDto.getRoleAccessList().stream().filter(roleWidgetActionDto ->
                        roleWidgetActionDto.getAction().equals(actionClass.getName())
                        && roleWidgetActionDto.getWidgetId().equals(widgetId)).findAny().orElse(null);
                if (null == accessExists){
                    throw  new Exception("Not authorised to perform this action");
                }
                BaseAction abstractBaseAction = (BaseAction) applicationContext.getBean(actionClass);
                abstractBaseAction.executeAction(httpServletRequest);
                abstractBaseAction.executeAction();
            } catch (ClassNotFoundException cnf){
                logger.error(cnf.getMessage());
            } catch (Exception e){
                logger.error(e.getMessage());
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
