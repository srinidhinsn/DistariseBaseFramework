package com.distarise.base.service;

import com.distarise.base.model.NavigationItemDto;
import java.util.List;

public interface NavigationItemService extends AbstractBaseService{
    List<NavigationItemDto> getNavigationItems(String navigationId);
    void saveNavigationItem(NavigationItemDto navigationItemDto);
}
