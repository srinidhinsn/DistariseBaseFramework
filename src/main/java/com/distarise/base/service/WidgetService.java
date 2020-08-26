package com.distarise.base.service;

import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.WidgetDto;
import java.util.List;

public interface WidgetService extends AbstractBaseService{
    List<WidgetDto> getWidgets(List<String> navigationItemIds, String clientId);
    List<WidgetDto> getWidgets(String navigationItemId, String clientId);
    void mapWidgetsToNavigationItems(List<NavigationItemDto> navigationItemDtos,
                                     List<WidgetDto> widgetDtos);
    WidgetDto getWidgetById(String clientId, String widgetId);
}
