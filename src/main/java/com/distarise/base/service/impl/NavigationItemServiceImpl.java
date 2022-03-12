package com.distarise.base.service.impl;

import com.distarise.base.dao.NavigationItemDao;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.service.AbstractBaseService;
import com.distarise.base.service.NavigationItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NavigationItemServiceImpl implements NavigationItemService {

    @Autowired
    NavigationItemDao navigationItemDao;

    public List<NavigationItemDto> getNavigationItems(String navigationId){
        return navigationItemDao.getNavigationItems(navigationId);
    }

    @Override
    public void saveNavigationItem(NavigationItemDto navigationItemDto) {
        navigationItemDao.saveNavigationItem(navigationItemDto);
    }
}
