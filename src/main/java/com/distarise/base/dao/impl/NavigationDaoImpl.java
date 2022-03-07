package com.distarise.base.dao.impl;

import com.distarise.base.dao.NavigationDao;
import com.distarise.base.entity.Navigation;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.repository.NavigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NavigationDaoImpl implements NavigationDao {

    @Autowired
    NavigationRepository navigationRepository;

    @Override
    public NavigationDto getNavigationDetails(String clientId, String module,
                                              String roleName){
        Navigation navigation = null;
        if (null != roleName){
             navigation = navigationRepository.getNavigationDetails(clientId, module, roleName);
        } else {
            navigation = navigationRepository.getNavigationDetails(clientId, module);
        }

        return modelMapper.map(navigation, NavigationDto.class);
    }

    @Override
    public List<NavigationDto> getAllNavigations(String clientId) {
        List<Navigation> navigationList = navigationRepository.getAllNavigations(clientId);
        List<NavigationDto> navigationDtoList = new ArrayList<>();
        navigationList.forEach(navigation -> {
            navigationDtoList.add(modelMapper.map(navigation, NavigationDto.class));
        });
        return navigationDtoList;
    }
}
