package com.distarise.base.repository;

import com.distarise.base.entity.NavigationItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NavigationItemRepository extends CrudRepository<NavigationItem, String> {

    @Query("from NavigationItem where navigationId = ?1 order by sortOrder asc")
    List<NavigationItem> getNavigationItems(String navigationId);
}
