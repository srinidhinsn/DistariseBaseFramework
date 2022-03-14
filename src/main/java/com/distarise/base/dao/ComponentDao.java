package com.distarise.base.dao;

import com.distarise.base.model.ComponentDto;

import java.util.List;

public interface ComponentDao extends AbstractBaseDao{
    List<ComponentDto> getComponents(List<String> widgetIds, String clientId);
    List<ComponentDto> getComponentsByWidgetId(String clientId, String widgetId);
    void saveComponent(ComponentDto componentDto);
    List<ComponentDto> getMultilevelComponentsByWidgetId(String clientId, String selectedWidget);
    List<ComponentDto> getActionsByClientId(String clientId);
}
