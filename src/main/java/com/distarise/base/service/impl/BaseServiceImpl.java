package com.distarise.base.service.impl;

import com.distarise.base.action.BaseAction;
import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.LayoutDto;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.AbstractBaseService;
import com.distarise.base.service.BaseService;
import com.distarise.base.service.ClientService;
import com.distarise.base.service.ComponentItemService;
import com.distarise.base.service.ComponentService;
import com.distarise.base.service.LayoutService;
import com.distarise.base.service.NavigationItemService;
import com.distarise.base.service.NavigationService;
import com.distarise.base.service.UserService;
import com.distarise.base.service.WidgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BaseServiceImpl implements BaseService, AbstractBaseService {

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    ClientService clientService;

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
    UserService userService;

    @Autowired
    LayoutService layoutService;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public PageDetailsDto getPageDetails(BaseContextDto baseContextDto) {
        PageDetailsDto pageDetailsDto = new PageDetailsDto();
            Map<String, LayoutDto> layoutDtoMap = layoutService.getAllLayoutDesigns();
            UserDetailsDto userDetailsDto = baseContextDto.getUserDetailsDto();
            Map<String, List<String>> allowedWidgetActions = getAllowedWidgetActions(
                    userDetailsDto.getRoleAccessList());
            logger.debug("Allowed widget action - "+allowedWidgetActions.entrySet());
            List<String> allowedWidgetIds = new ArrayList<>(allowedWidgetActions.keySet());
            ClientDto clientDto = clientService.getClientDetails(baseContextDto.getClientId());
            NavigationDto navigationDto = navigationService.getNavigationDetails(baseContextDto.getClientId(),
                    baseContextDto.getModule(), userDetailsDto.getRoleName());
            List<NavigationItemDto> navigationItemDtos = navigationItemService.getNavigationItems(
                    navigationDto.getId());
            logger.debug("navigationItemDtos item size - "+navigationItemDtos.size());
            navigationDto.setNavigationItems(navigationItemDtos);
            NavigationItemDto navigationItemDto = navigationItemDtos.stream().filter(findNavigationItemDto ->
                    findNavigationItemDto.getId().equalsIgnoreCase(baseContextDto.getPageName())).
                    findAny().orElse(navigationItemDtos.get(0));
            navigationItemDto.setLayoutDto(layoutDtoMap.get(navigationItemDto.getLayoutId()));
            List<WidgetDto> widgetDtos = widgetService.getWidgets(navigationItemDto.getId(), baseContextDto.getClientId(),
                    allowedWidgetIds);
            logger.debug("widgetDtos size - "+widgetDtos.size());
            List<ComponentDto> componentDtos = componentService.getComponents(allowedWidgetIds, baseContextDto.getClientId());
            List<String> componentIds = componentDtos.stream().
                    map(componentDto -> componentDto.getId()).collect(Collectors.toList());
            logger.debug("componentIds size - "+componentIds.size());
            List<ComponentItemDto> componentItemDtos = componentItemService.getComponentItems(componentIds, baseContextDto.getClientId());
            logger.debug("componentItemDtos size - "+componentItemDtos.size());
            componentItemService.mapComponentItemsToComponents(componentDtos, componentItemDtos);
            componentService.mapComponentsToWidget(widgetDtos, componentDtos, allowedWidgetActions);
            widgetService.mapWidgetsToNavigationItems(navigationItemDtos, widgetDtos);
            widgetService.mapLayoutsToWidgets(widgetDtos, layoutDtoMap);
            pageDetailsDto.setNavigationDto(navigationDto);
            pageDetailsDto.setClientDto(clientDto);

        return pageDetailsDto;
    }

    private Map<String, List<String>> getAllowedWidgetActions(List<RoleWidgetActionDto> roleWidgetActionDtoList){
        List<String> allowedWidgetIds = roleWidgetActionDtoList.stream().
                map(roleWidgetActionDto -> roleWidgetActionDto.getWidgetId()).collect(Collectors.toList());
        Map<String, List<String>> allowedWidgetActions = new HashMap<>();
        roleWidgetActionDtoList.forEach(roleWidgetActionDto -> {
            if (allowedWidgetActions.containsKey(roleWidgetActionDto.getWidgetId())){
                List<String> actions = allowedWidgetActions.get(roleWidgetActionDto.getWidgetId());
                actions.add(roleWidgetActionDto.getAction());
            } else {
                List<String> actions = new ArrayList<>();
                actions.add(roleWidgetActionDto.getAction());
                allowedWidgetActions.put(roleWidgetActionDto.getWidgetId(), actions);
            }
        });
        return allowedWidgetActions;
    }

    @Override
    public void preloadWidgets(HttpServletRequest request, PageDetailsDto pageDetailsDto, BaseContextDto baseContextDto){
        List<NavigationItemDto> navigationItemDtos = pageDetailsDto.getNavigationDto().getNavigationItems();
        NavigationItemDto navigationItemDto = navigationItemDtos
                .stream().filter(findNavigationItemDto ->
                findNavigationItemDto.getId().equalsIgnoreCase(baseContextDto.getPageName())).
                findAny().orElse(navigationItemDtos.get(0));

        navigationItemDto.getWidgets().forEach(widgetDto -> {
            widgetDto.getComponentDtos().forEach(componentDto -> {
                if (componentDto.getType().equalsIgnoreCase(AUTO_ACTION)){
                    try {
                        Class actionClass = Class.forName(componentDto.getKeyOrAction());
                        BaseAction abstractBaseAction = (BaseAction) applicationContext.getBean(actionClass);
                        abstractBaseAction.executeAction(request);
                        abstractBaseAction.executeAction();
                    }catch (ClassNotFoundException cnf){
                        logger.error(cnf.getMessage());
                    }
                }
            });
        });
    }


}
