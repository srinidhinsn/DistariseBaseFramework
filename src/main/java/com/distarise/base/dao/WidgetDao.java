package com.distarise.base.dao;

import com.distarise.base.model.WidgetDto;

import java.util.List;

public interface WidgetDao extends AbstractBaseDao{
    List<WidgetDto> getWidgets(String navigationItemId, String clientId, List<String> widgetIds);
    WidgetDto getWidgetById(String clientId, String widgetId, String navItemId);
    List<WidgetDto> getWidgetByNavigationItemId(String clientId, String navigationItemId);
    void saveWidget(WidgetDto widgetDto);
    List<WidgetDto> getWidgetsByClientId(String clientId);
}
