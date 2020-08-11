package com.distarise.base.service.impl;

import com.distarise.base.dao.ComponentDao;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.ComponentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentServiceImpl implements ComponentService {

    @Autowired
    ComponentDao componentDao;

    @Override
    public List<ComponentDto> getComponents(List<String> widgetIds, String clientId){
        return componentDao.getComponents(widgetIds, clientId);
    }

    @Override
    public void mapComponentsToWidget(List<WidgetDto> widgetDtos,
                                      List<ComponentDto> componentDtos){
        widgetDtos.forEach(widgetDto -> {
            List<ComponentDto> componentDtoList = new ArrayList<>();
            widgetDto.setComponentDtos(componentDtoList);
            componentDtos.forEach(componentDto -> {
                if (componentDto.getWidgetId().equalsIgnoreCase(componentDto.getId())){
                    componentDtoList.add(componentDto);
                }
            });
        });
    }
}
