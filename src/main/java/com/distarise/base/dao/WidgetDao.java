package com.distarise.base.dao;

import com.distarise.base.model.WidgetDto;
import java.util.List;

public interface WidgetDao extends AbstractBaseDao{
    List<WidgetDto> getWidgets(List<String> navigationItemIds, String clientId);
    List<WidgetDto> getWidgets(String navigationItemId, String clientId);
    WidgetDto getWidgetById(String clientId, String widgetId);
}
