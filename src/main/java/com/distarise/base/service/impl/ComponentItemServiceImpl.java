package com.distarise.base.service.impl;

import com.distarise.base.dao.ComponentItemDao;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.service.ComponentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComponentItemServiceImpl implements ComponentItemService {

    @Autowired
    ComponentItemDao componentItemDao;

    @Override
    public List<ComponentItemDto> getComponentItems(List<String> componentIds, String clientId){
        return componentItemDao.getComponentItems(componentIds, clientId);
    }

    @Override
    public void mapComponentItemsToComponents(List<ComponentDto> componentDtoList,
                                       List<ComponentItemDto> componentItemDtoList){
        componentDtoList.forEach(componentDto -> {
            List<ComponentItemDto> componentItemDtos = new ArrayList<>();
            componentDto.setComponentItemDtos(componentItemDtos);
            componentItemDtoList.forEach(componentItemDto -> {
                if (componentDto.getId().equalsIgnoreCase(componentItemDto.getComponentId())){
                    componentItemDtos.add(componentItemDto);
                }
            });
        });
    }
}
