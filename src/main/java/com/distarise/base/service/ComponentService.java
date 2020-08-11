package com.distarise.base.service;

import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.WidgetDto;
import java.util.List;

public interface ComponentService extends AbstractBaseService{
    List<ComponentDto> getComponents(List<String> widgetIds, String clientId);
    void mapComponentsToWidget(List<WidgetDto> widgetDtos,
                               List<ComponentDto> componentDtos);
}
