package com.distarise.base.service.impl;

import com.distarise.base.dao.NavigationDao;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.service.NavigationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    NavigationDao navigationDao;

    @Override
    public NavigationDto getNavigationDetails(String clientId, String module,
                                              List<String> roleNames){
        return navigationDao.getNavigationDetails(clientId, module, roleNames);
    }
}
