package com.distarise.base.dao.impl;

import com.distarise.base.dao.ComponentDao;
import com.distarise.base.entity.Component;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.repository.ComponentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Component
public class ComponentDaoImpl implements ComponentDao {

    @Autowired
    ComponentRepository componentRepository;

    @Override
    public List<ComponentDto> getComponents(List<String> widgetIds, String clientId){
        List<Component> components = componentRepository.getComponents(widgetIds, clientId);
        List<ComponentDto> componentDtos = components.stream()
                .map(component -> modelMapper.map(component, ComponentDto.class))
                .collect(Collectors.toList());
        return componentDtos;
    }
}
