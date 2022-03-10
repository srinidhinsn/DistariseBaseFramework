package com.distarise.base.dao;

import com.distarise.base.model.WidgetDto;
import java.util.List;
import java.util.Set;

public interface WidgetDao extends AbstractBaseDao{
    List<WidgetDto> getWidgets(String navigationItemId, String clientId, List<String> widgetIds);
    WidgetDto getWidgetById(String clientId, String widgetId);
    List<WidgetDto> getWidgetByNavigationItemId(String clientId, String navigationItemId);
}
