package com.distarise.base.dao.impl;

import com.distarise.base.dao.WidgetDao;
import com.distarise.base.entity.Widget;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.repository.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WidgetDaoImpl implements WidgetDao {

    @Autowired
    WidgetRepository widgetRepository;

    @Override
    public List<WidgetDto> getWidgets(String navigationId, String clientId, List<String> widgetIds){
        List<Widget> widgets = widgetRepository.getWidgets(navigationId, clientId, widgetIds);
        List<WidgetDto> widgetDtos = widgets.stream()
                .map(widget -> modelMapper.map(widget, WidgetDto.class))
                .collect(Collectors.toList());
        return widgetDtos;
    }

    @Override
    public WidgetDto getWidgetById(String clientId, String widgetId){
        Widget widget = widgetRepository.getWidgetById(clientId, widgetId);
        return modelMapper.map(widget, WidgetDto.class);
    }

    @Override
    public List<WidgetDto> getWidgetByNavigationItemId(String clientId, String navigationItemId) {
        List<Widget> widgetList = widgetRepository.getWidgetByNavigationItemId(clientId, navigationItemId);
        return convertEntityListToDtoList(widgetList);
    }

    private List<WidgetDto> convertEntityListToDtoList(List<Widget> widgetList){
        return widgetList.stream().map(widget -> modelMapper.map(widget, WidgetDto.class)).collect(Collectors.toList());
    }

    @Override
    public void saveWidget(WidgetDto widgetDto) {
        widgetRepository.save(modelMapper.map(widgetDto, Widget.class));
    }
}
