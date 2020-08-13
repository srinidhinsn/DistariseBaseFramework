package com.distarise.base.service.impl;

import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.AbstractBaseService;
import com.distarise.base.service.BaseService;
import com.distarise.base.service.ClientService;
import com.distarise.base.service.ComponentService;
import com.distarise.base.service.NavigationItemService;
import com.distarise.base.service.NavigationService;
import com.distarise.base.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaseServiceImpl implements BaseService, AbstractBaseService {

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

    @Override
    public PageDetailsDto getPageDetails(BaseContextDto baseContextDto) {
        PageDetailsDto pageDetailsDto = new PageDetailsDto();
        if (baseContextDto.getUserRoleDto().isPresent()){

        } else{
            ClientDto clientDto = clientService.getClientDetails(baseContextDto.getClientId());
            NavigationDto navigationDto = navigationService.getNavigationDetails(baseContextDto.getClientId(),
                    baseContextDto.getModule(), null);
            List<NavigationItemDto> navigationItemDtos = navigationItemService.getNavigationItems(
                    navigationDto.getId());
            navigationDto.setNavigationItems(navigationItemDtos);
            List<String> navigationItemIds = navigationItemDtos.stream()
                    .map(navigationItemDto -> navigationItemDto.getId())
                    .collect(Collectors.toList());
            List<WidgetDto> widgetDtos = widgetService.getWidgets(navigationItemIds, baseContextDto.getClientId());
            List<String> widgetIds = widgetDtos.stream()
                    .map(widgetDto -> widgetDto.getId())
                    .collect(Collectors.toList());
            List<ComponentDto> componentDtos = componentService.getComponents(widgetIds, baseContextDto.getClientId());
            componentService.mapComponentsToWidget(widgetDtos, componentDtos);
            widgetService.mapWidgetsToNavigationItems(navigationItemDtos, widgetDtos);
            pageDetailsDto.setNavigationDto(navigationDto);
            pageDetailsDto.setClientDto(clientDto);
        }
        return pageDetailsDto;
    }
}
