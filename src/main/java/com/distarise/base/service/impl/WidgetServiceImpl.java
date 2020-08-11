package com.distarise.base.service.impl;

import com.distarise.base.dao.WidgetDao;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.WidgetService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetServiceImpl implements WidgetService {

    @Autowired
    WidgetDao widgetDao;

    @Override
    public List<WidgetDto> getWidgets(List<String> navigationItemIds, String clientId){
        return widgetDao.getWidgets(navigationItemIds, clientId);
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
}
