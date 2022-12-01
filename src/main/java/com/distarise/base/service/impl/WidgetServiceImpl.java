package com.distarise.base.service.impl;

import com.distarise.base.dao.ComponentDao;
import com.distarise.base.dao.WidgetDao;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.LayoutDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WidgetServiceImpl implements WidgetService {

    @Autowired
    WidgetDao widgetDao;

    @Autowired
    ComponentDao componentDao;

    @Override
    public List<WidgetDto> getWidgets(String navigationItemId, String clientId, List<String> widgetIds){
        return widgetDao.getWidgets(navigationItemId, clientId, widgetIds);
    }

    public void mapWidgetsToNavigationItems(List<NavigationItemDto> navigationItemDtos,
                                            List<WidgetDto> widgetDtos){
        navigationItemDtos.forEach(navigationItemDto -> {
            List<WidgetDto> widgetDtoList= new ArrayList<>();
            navigationItemDto.setWidgets(widgetDtoList);
            widgetDtos.forEach(widgetDto -> {
                if (widgetDto.getNavigationItemId().equalsIgnoreCase(navigationItemDto.getId())){
                    widgetDtoList.add(widgetDto);
                }
            });
        });
    }

    @Override
    public WidgetDto getWidgetById(String clientId, String widgetId, String navItemId){
        WidgetDto widgetDto = widgetDao.getWidgetById(clientId, widgetId, navItemId);
        widgetDto.setComponentDtos(componentDao.getComponentsByWidgetId(clientId, widgetId));
        return widgetDto;
    }

    @Override
    public void mapLayoutsToWidgets(List<WidgetDto> widgetDtos, Map<String, LayoutDto> layoutDtoMap){
        widgetDtos.forEach(widgetDto -> widgetDto.setLayoutDto(layoutDtoMap.get(widgetDto.getLayoutId())));
    }

    @Override
    public List<WidgetDto> getWidgetByNavigationItemId(String clientId, String navigationItemId) {
        return widgetDao.getWidgetByNavigationItemId(clientId, navigationItemId);
    }

    @Override
    public void saveWidget(WidgetDto widgetDto) {
        widgetDao.saveWidget(widgetDto);
    }

    @Override
    public List<WidgetDto> getWidgetsByClientId(String clientId) {
        return widgetDao.getWidgetsByClientId(clientId);
    }

    @Override
    public WidgetDto getMessageWidget(String clientId, String navItemId, PageDetailsDto pageDetailsDto) {
        Map<String, String> messages = new HashMap<>();
        if (null != pageDetailsDto.getSuccessMessages() && !pageDetailsDto.getSuccessMessages().isEmpty()){
            messages.put("SUCCESS", getMessage(pageDetailsDto.getSuccessMessages()));
        }
        if (null != pageDetailsDto.getErrorMessages() && !pageDetailsDto.getErrorMessages().isEmpty()){
            messages.put("ERROR", getMessage(pageDetailsDto.getErrorMessages()));
        }
        if (null != pageDetailsDto.getWarningMessages() && !pageDetailsDto.getWarningMessages().isEmpty()){
            messages.put("WARNING", getMessage(pageDetailsDto.getWarningMessages()));
        }
        if (messages.isEmpty()){
            return null;
        }

        WidgetDto widgetDto = new WidgetDto("message", clientId, navItemId, null,
                "", null, -1, null, null, null, null, null, null);
        ComponentDto componentDto = new ComponentDto("message", "message", clientId, 0, "message",
                "", false, "", true, "", false, null, null, null, null);
        List<ComponentDto> componentDtoList = new ArrayList<>();
        List<Map<String, String>> gridList = new ArrayList<>();

        gridList.add(messages);
        componentDto.setGridValues(gridList);
        componentDtoList.add(componentDto);
        widgetDto.setComponentDtos(componentDtoList);
        return widgetDto;
    }

    private String getMessage(List<String> messages){
        StringBuffer stringBuffer = new StringBuffer();
        messages.forEach(s -> {
            stringBuffer.append(s + "\n");
        });
        return stringBuffer.toString();
    }
}
