package com.distarise.base.dao;

import com.distarise.base.model.NavigationItemDto;
import java.util.List;

public interface NavigationItemDao extends AbstractBaseDao {
    List<NavigationItemDto> getNavigationItems(String navigationId);
    void saveNavigationItem(NavigationItemDto navigationItemDto);
}
