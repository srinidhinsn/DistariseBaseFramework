package com.distarise.base.repository;

import com.distarise.base.entity.Widget;
import com.distarise.base.entity.WidgetId;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetRepository extends CrudRepository<Widget, WidgetId> {

    @Query("from Widget where navigationItemId in (?1) and clientId = ?2")
    List<Widget> getWidgets(List<String> navigationItemIds, String clientId);
}
