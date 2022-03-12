package com.distarise.base.dao;

import com.distarise.base.model.ComponentItemDto;

import java.util.List;

public interface ComponentItemDao extends AbstractBaseDao {
    List<ComponentItemDto> getComponentItems(List<String> componentIds, String clientId);
    List<ComponentItemDto> getComponentItemsByComponentId(String clientId, String selectedComponent);
    void saveComponentItem(ComponentItemDto componentItemDto);
}
