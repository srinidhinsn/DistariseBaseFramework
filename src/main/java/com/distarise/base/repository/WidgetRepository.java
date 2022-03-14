package com.distarise.base.repository;

import com.distarise.base.entity.Widget;
import com.distarise.base.entity.WidgetId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WidgetRepository extends CrudRepository<Widget, WidgetId> {

    @Query("from Widget where navigationItemId =?1 and clientId = ?2 and id in (?3) order by sortOrder asc")
    List<Widget> getWidgets(String navigationItemId, String clientId, List<String> widgetIds);

    @Query("from Widget where clientId = ?1 and id = ?2 and navigationItemId = ?3 order by sortOrder asc")
    Widget getWidgetById(String clientId, String widgetId, String navItemId);

    @Query("from Widget where clientId = ?1 and navigationItemId =?2 order by sortOrder asc")
    List<Widget> getWidgetByNavigationItemId(String clientId, String navigationItemId);

    @Query("from Widget where clientId = ?1 order by id asc")
    List<Widget> getWidgetsByClientId(String clientId);
}
