package com.distarise.base.dao.impl;

import com.distarise.base.dao.NavigationItemDao;
import com.distarise.base.entity.NavigationItem;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.repository.NavigationItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NavigationItemDaoImpl implements NavigationItemDao {

    @Autowired
    NavigationItemRepository navigationItemRepository;

    @Override
    public List<NavigationItemDto> getNavigationItems(String navigationId){
        List<NavigationItem> navigationItems = navigationItemRepository.getNavigationItems(navigationId);
        List<NavigationItemDto> navigationItemDtos = navigationItems.stream().
                map(navigationItem -> modelMapper.map(navigationItem, NavigationItemDto.class)).
                collect(Collectors.toList());
        return navigationItemDtos;
    }

    @Override
    public void saveNavigationItem(NavigationItemDto navigationItemDto) {
        navigationItemRepository.save(modelMapper.map(navigationItemDto, NavigationItem.class));
    }
}
