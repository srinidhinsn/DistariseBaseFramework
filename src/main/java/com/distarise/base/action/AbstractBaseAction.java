package com.distarise.base.action;

import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.ComponentService;
import com.distarise.base.service.NavigationItemService;
import com.distarise.base.service.NavigationService;
import com.distarise.base.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
public class AbstractBaseAction implements BaseAction {
    private HttpServletRequest request = null;
    private String[] actionIdentifier;
    private String[] url;
    private String clientId;
    private String widgetId;
    private String navigationId;
    private String navigationItemId;


    @Autowired
    NavigationService navigationService;

    @Autowired
    NavigationItemService navigationItemService;

    @Autowired
    WidgetService widgetService;

    @Autowired
    ComponentService componentService;

    @Override
    final public void executeAction(HttpServletRequest httpServletRequest){
        request = httpServletRequest;
        url = request.getRequestURI().split("/");
        clientId = url[1];

        actionIdentifier = request.getParameter("actionIdentifier").split("-");
        navigationId = actionIdentifier[0];
        navigationItemId = actionIdentifier[1];
        widgetId = actionIdentifier[2];
    }

    @Override
    public PageDetailsDto executeAction(PageDetailsDto pageDetailsDto){

        return pageDetailsDto;
    }

    @Override
    public NavigationDto executeAction(NavigationDto navigationDto){

        return navigationDto;
    }

    @Override
    public NavigationItemDto executeAction(NavigationItemDto navigationItemDto){

        return navigationItemDto;
    }

    @Override
    public WidgetDto executeAction(WidgetDto widgetDto){
        widgetDto = widgetService.getWidgetById(clientId, widgetId);
        widgetDto.getComponentDtos().forEach(componentDto -> {
            Enumeration<String> params = request.getParameterNames();
            while (params.hasMoreElements()){
                String param = params.nextElement();
                if (param.equalsIgnoreCase(componentDto.getId())){
                    componentDto.setValue(request.getParameter(param));
                }
            };
        });
        return widgetDto;
    }

}
