package com.distarise.base.dao.impl;

import com.distarise.base.dao.ComponentItemDao;
import com.distarise.base.entity.ComponentItem;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.repository.ComponentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComponentItemDaoImpl implements ComponentItemDao {

    @Autowired
    ComponentItemRepository componentItemRepository;

    @Override
    public List<ComponentItemDto> getComponentItems(List<String> componentIds, String clientId){
        List<ComponentItem> componentItems = componentItemRepository.getComponents(componentIds, clientId);
        List<ComponentItemDto> componentItemDtoList = convertEntityListToDtoList(componentItems);
        return componentItemDtoList;
    }

    public  List<ComponentItemDto> convertEntityListToDtoList(List<ComponentItem> componentItemList){
        return componentItemList.stream()
                .map(componentItem -> modelMapper.map(componentItem, ComponentItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ComponentItemDto> getComponentItemsByComponentId(String clientId, String selectedComponent) {
        List<ComponentItem> componentItemList = componentItemRepository.getComponentItemsByComponentId(clientId, selectedComponent);
        return convertEntityListToDtoList(componentItemList);
    }

    @Override
    public void saveComponentItem(ComponentItemDto componentItemDto) {
        componentItemRepository.save(modelMapper.map(componentItemDto, ComponentItem.class));
    }
}
