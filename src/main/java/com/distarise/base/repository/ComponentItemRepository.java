package com.distarise.base.repository;

import com.distarise.base.entity.ComponentItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentItemRepository extends CrudRepository<ComponentItem, String> {
    @Query("from ComponentItem where componentId in (?1) and clientId = ?2 order by sortOrder asc")
    List<ComponentItem> getComponents(List<String> componentIds, String clientId);

    @Query("from ComponentItem where clientId = ?1 and componentId = ?2 order by sortOrder asc")
    List<ComponentItem> getComponentItemsByComponentId(String clientId, String selectedComponent);
}
