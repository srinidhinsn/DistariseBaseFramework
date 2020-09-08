package com.distarise.base.service;

import com.distarise.base.model.LayoutDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.WidgetDto;

import java.util.List;
import java.util.Map;

public interface WidgetService extends AbstractBaseService{
    List<WidgetDto> getWidgets(String navigationItemId, String clientId, List<String> widgetIds);
    void mapWidgetsToNavigationItems(List<NavigationItemDto> navigationItemDtos,
                                     List<WidgetDto> widgetDtos);
    WidgetDto getWidgetById(String clientId, String widgetId);

    void mapLayoutsToWidgets(List<WidgetDto> widgetDtos, Map<String, LayoutDto> layoutDtoMap);
}
