package com.distarise.base.action;

import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.ComponentItemService;
import com.distarise.base.service.ComponentService;
import com.distarise.base.service.NavigationItemService;
import com.distarise.base.service.NavigationService;
import com.distarise.base.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AbstractBaseAction implements BaseAction {
    public HttpServletRequest request = null;
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

    @Autowired
    ComponentItemService componentItemService;

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
        List<String> componentIds = widgetDto.getComponentDtos().stream().
                map(componentDto -> componentDto.getId()).collect(Collectors.toList());
        List<ComponentItemDto> componentItems = componentItemService.getComponentItems(componentIds, clientId);
        componentItemService.mapComponentItemsToComponents(widgetDto.getComponentDtos(), componentItems);
        widgetDto.getComponentDtos().forEach(componentDto -> {

            if (componentDto.getMultiLevel()){
                componentDto.getComponentItemDtos().forEach(componentItemDto -> {
                    Enumeration<String> params = request.getParameterNames();
                    componentItemDto.setValue(CHECKBOX_UNCHECKED);
                    while (params.hasMoreElements()){
                        String param = params.nextElement();
                        if (param.equalsIgnoreCase(componentItemDto.getComponentId()+"-"
                                +componentItemDto.getLabel())){
                            componentItemDto.setValue(CHECKBOX_CHECKED);
                            break;
                        }
                    };
                });
            }
            else {
                Enumeration<String> params = request.getParameterNames();
                while (params.hasMoreElements()) {
                    String param = params.nextElement();
                    if (param.equalsIgnoreCase(componentDto.getId())) {
                        componentDto.setValue(request.getParameter(param));
                        break;
                    }
                }
                ;
            }
        });
        return widgetDto;
    }

    @Override
    public void executeAction(){}

}
