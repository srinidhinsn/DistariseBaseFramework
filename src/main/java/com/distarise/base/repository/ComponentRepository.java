package com.distarise.base.repository;

import com.distarise.base.entity.Component;
import com.distarise.base.entity.ComponentId;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends CrudRepository<Component, ComponentId> {

    @Query("from Component where widgetId in (?1) and clientId = ?2 order by sortOrder asc")
    List<Component> getComponents(List<String> widgetIds, String clientId);

    @Query("from Component where clientId = ?1 and widgetId = ?2 order by sortOrder asc")
    List<Component> getComponentsByWidgetId(String clientId, String widgetId);
}
