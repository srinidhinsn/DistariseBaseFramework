package com.distarise.base.service.impl;

import com.distarise.base.dao.NavigationDao;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    NavigationDao navigationDao;

    @Override
    public NavigationDto getNavigationDetails(String clientId, String module,
                                              String roleName){
        return navigationDao.getNavigationDetails(clientId, module, roleName);
    }

    @Override
    public List<NavigationDto> getAllNavigations(String clientId) {
        return navigationDao.getAllNavigations(clientId);
    }
}
