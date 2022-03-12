package com.distarise.base.service.impl;

import com.distarise.base.dao.ComponentDao;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ComponentServiceImpl implements ComponentService {

    @Autowired
    ComponentDao componentDao;

    @Override
    public List<ComponentDto> getComponents(List<String> widgetIds, String clientId){
        return componentDao.getComponents(widgetIds, clientId);
    }

    @Override
    public void mapComponentsToWidget(List<WidgetDto> widgetDtos, List<ComponentDto> componentDtos,
                                      Map<String, List<String>> roleWidgetActions){
        widgetDtos.forEach(widgetDto -> {
            List<ComponentDto> componentDtoList = new ArrayList<>();
            widgetDto.setComponentDtos(componentDtoList);
            componentDtos.forEach(componentDto -> {
                if (componentDto.getWidgetId().equalsIgnoreCase(widgetDto.getId())){
                    List<String> allowedActions = roleWidgetActions.get(widgetDto.getId());
                    if (null != componentDto.getKeyOrAction()){
                        if (allowedActions.contains(componentDto.getKeyOrAction())){
                            componentDtoList.add(componentDto);
                        }
                    }else {
                        componentDtoList.add(componentDto);
                    }
                }
            });
        });
    }

    @Override
    public List<ComponentDto> getComponentsByWidgetId(String clientId, String selectedWidget) {
        return componentDao.getComponentsByWidgetId(clientId, selectedWidget);
    }

    @Override
    public void saveComponent(ComponentDto componentDto) {
        componentDao.saveComponent(componentDto);
    }

    @Override
    public List<ComponentDto> getMultilevelComponentsByWidgetId(String clientId, String selectedWidget) {
        return componentDao.getMultilevelComponentsByWidgetId(clientId, selectedWidget);
    }
}
