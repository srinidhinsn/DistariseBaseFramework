package com.distarise.base.service;

import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.WidgetDto;

import java.util.List;
import java.util.Map;

public interface ComponentService extends AbstractBaseService{
    List<ComponentDto> getComponents(List<String> widgetIds, String clientId);
    void mapComponentsToWidget(List<WidgetDto> widgetDtos, List<ComponentDto> componentDtos,
                               Map<String, List<String>> roleWidgetActions);
    List<ComponentDto> getComponentsByWidgetId(String clientId, String selectedWidget);
    void saveComponent(ComponentDto componentDto);
    List<ComponentDto> getMultilevelComponentsByWidgetId(String clientId, String selectedWidget);
}
