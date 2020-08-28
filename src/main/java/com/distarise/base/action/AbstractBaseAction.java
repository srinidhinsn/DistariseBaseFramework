package com.distarise.base.action;

import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.UserRoleDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.BaseService;
import com.distarise.base.service.ComponentItemService;
import com.distarise.base.service.ComponentService;
import com.distarise.base.service.NavigationItemService;
import com.distarise.base.service.NavigationService;
import com.distarise.base.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AbstractBaseAction implements BaseAction{
    public HttpServletRequest request = null;
    private String[] actionIdentifier;
    private String[] url;
    private String clientId;
    private String module;
    private String page;
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

    @Autowired
    BaseService baseService;

    final public void executeAction(HttpServletRequest httpServletRequest){
        request = httpServletRequest;
        url = request.getRequestURI().split("/");
        clientId = url[1];
        module = url[2];
        page = url[3];

        actionIdentifier = request.getParameter("actionIdentifier").split("-");
        navigationId = actionIdentifier[0];
        navigationItemId = actionIdentifier[1];
        widgetId = actionIdentifier[2];
    }

    public PageDetailsDto executeAction(PageDetailsDto pageDetailsDto){
        HttpSession session = request.getSession();
        BaseContextDto baseContextDto = new BaseContextDto(clientId, module, page,
                Optional.ofNullable((UserRoleDto) session.getAttribute("userRoleDto")));
        pageDetailsDto = baseService.getPageDetails(baseContextDto);
        return pageDetailsDto;
    }

    public NavigationDto executeAction(NavigationDto navigationDto){

        return navigationDto;
    }

    public NavigationItemDto executeAction(NavigationItemDto navigationItemDto){

        return navigationItemDto;
    }

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
