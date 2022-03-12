package com.distarise.base.service;

import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ComponentItemDto;

import java.util.List;

public interface ComponentItemService extends AbstractBaseService {
    List<ComponentItemDto> getComponentItems(List<String> componentIds, String clientId);
    void mapComponentItemsToComponents(List<ComponentDto> componentDtoList,
                                       List<ComponentItemDto> componentItemDtoList);
    List<ComponentItemDto> getComponentItemsByComponentId(String clientId, String selectedComponent);
    void saveComponentItem(ComponentItemDto componentItemDto);
}
