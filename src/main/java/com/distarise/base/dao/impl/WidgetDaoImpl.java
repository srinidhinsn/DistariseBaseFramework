package com.distarise.base.dao.impl;

import com.distarise.base.dao.WidgetDao;
import com.distarise.base.entity.Widget;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.repository.WidgetRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WidgetDaoImpl implements WidgetDao {

    @Autowired
    WidgetRepository widgetRepository;

    @Override
    public List<WidgetDto> getWidgets(List<String> navigationIds, String clientId){
        List<Widget> widgets = widgetRepository.getWidgets(navigationIds, clientId);
        List<WidgetDto> widgetDtos = widgets.stream()
                .map(widget -> modelMapper.map(widget, WidgetDto.class))
                .collect(Collectors.toList());
        return widgetDtos;
    }
}
