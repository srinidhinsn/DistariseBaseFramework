package com.distarise.base.service.impl;

import com.distarise.base.dao.ComponentDao;
import com.distarise.base.dao.WidgetDao;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetServiceImpl implements WidgetService {

    @Autowired
    WidgetDao widgetDao;

    @Autowired
    ComponentDao componentDao;

    @Override
    public List<WidgetDto> getWidgets(String navigationItemId, String clientId, List<String> widgetIds){
        return widgetDao.getWidgets(navigationItemId, clientId, widgetIds);
    }

    public void mapWidgetsToNavigationItems(List<NavigationItemDto> navigationItemDtos,
                                            List<WidgetDto> widgetDtos){
        navigationItemDtos.forEach(navigationItemDto -> {
            List<WidgetDto> widgetDtoList= new ArrayList<>();
            navigationItemDto.setWidgets(widgetDtoList);
            widgetDtos.forEach(widgetDto -> {
                if (widgetDto.getNavigationItemId().equalsIgnoreCase(navigationItemDto.getId())){
                    widgetDtoList.add(widgetDto);
                }
            });
        });
    }

    @Override
    public WidgetDto getWidgetById(String clientId, String widgetId){
        WidgetDto widgetDto = widgetDao.getWidgetById(clientId, widgetId);
        widgetDto.setComponentDtos(componentDao.getComponentsByWidgetId(clientId, widgetId));
        return widgetDto;
    }
}
