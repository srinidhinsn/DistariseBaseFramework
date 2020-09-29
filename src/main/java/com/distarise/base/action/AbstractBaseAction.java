package com.distarise.base.action;

import com.distarise.base.controller.BaseController;
import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.AbstractBaseService;
import com.distarise.base.service.BaseService;
import com.distarise.base.service.ComponentItemService;
import com.distarise.base.service.ComponentService;
import com.distarise.base.service.NavigationItemService;
import com.distarise.base.service.NavigationService;
import com.distarise.base.service.UserService;
import com.distarise.base.service.WidgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class AbstractBaseAction implements BaseAction{
    public HttpServletRequest request = null;
    private String[] actionIdentifier;
    private String clientId;
    private String module;
    private String redirectPage;
    private String sourceWidgetId;
    private String sourceNavigationId;
    private String sourceNavigationItemId;
    BaseContextDto baseContextDto;

    private static final Logger logger = LoggerFactory.getLogger(AbstractBaseAction.class);

    @Autowired
    UserService userService;

    @Autowired
    NavigationService navigationService;

    @Autowired
    NavigationItemService navigationItemService;

    @Autowired
    WidgetService widgetService;

    @Autowired
    ComponentService componentService;

    @Autowired
    ComponentItemService componentItemService;

    @Autowired
    BaseService baseService;

    final public void executeAction(HttpServletRequest httpServletRequest){
        request = httpServletRequest;
        HttpSession session = request.getSession();
        baseContextDto = (BaseContextDto) session.getAttribute(AbstractBaseService.BASE_CONTEXT);
        redirectPage = baseContextDto.getPageName();
        clientId = baseContextDto.getClientId();
        module = baseContextDto.getModule();

        if (null != request.getParameter("actionIdentifier")) {
            actionIdentifier = request.getParameter("actionIdentifier").split("-");
            sourceNavigationId = actionIdentifier[0];
            sourceNavigationItemId = actionIdentifier[1];
            sourceWidgetId = actionIdentifier[2];
        }
    }

    public PageDetailsDto executeAction(PageDetailsDto pageDetailsDto){
        if (null != request.getAttribute(BaseAction.PAGE_DETAILS)){
            pageDetailsDto = (PageDetailsDto) request.getAttribute(BaseAction.PAGE_DETAILS);
            logger.debug("Found page details - "+pageDetailsDto.getUrl());
        }else {
            pageDetailsDto = baseService.getPageDetails(baseContextDto);
            request.setAttribute(BaseAction.PAGE_DETAILS, pageDetailsDto);
        }

        return pageDetailsDto;
    }

    public NavigationDto executeAction(NavigationDto navigationDto){

        return navigationDto;
    }

    public NavigationItemDto executeAction(NavigationItemDto navigationItemDto){

        return navigationItemDto;
    }

    public String getClientId() {
        return clientId;
    }

    public String getModule() {
        return module;
    }

    public String getRedirectPage() {
        return redirectPage;
    }

    public String getSourceWidgetId() {
        return sourceWidgetId;
    }

    public String getSourceNavigationId() {
        return sourceNavigationId;
    }

    public String getSourceNavigationItemId() {
        return sourceNavigationItemId;
    }

    public WidgetDto executeAction(WidgetDto widgetDto){
        widgetDto = widgetService.getWidgetById(clientId, sourceWidgetId);
        List<String> componentIds = widgetDto.getComponentDtos().stream().
                map(componentDto -> componentDto.getId()).collect(Collectors.toList());
        List<ComponentItemDto> componentItems = componentItemService.getComponentItems(componentIds, clientId);
        componentItemService.mapComponentItemsToComponents(widgetDto.getComponentDtos(), componentItems);

        widgetDto.getComponentDtos().forEach(componentDto -> {
            Enumeration<String> params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String param = params.nextElement();
                if (param.equalsIgnoreCase(componentDto.getId())) {
                    componentDto.setValue(request.getParameter(param));
                    break;
                }
            };
        });

        return widgetDto;
    }

    @Override
    abstract public void executeAction();

}
