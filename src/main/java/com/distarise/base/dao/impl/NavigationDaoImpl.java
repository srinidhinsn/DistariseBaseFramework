package com.distarise.base.dao.impl;

import com.distarise.base.dao.NavigationDao;
import com.distarise.base.entity.Navigation;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.repository.NavigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NavigationDaoImpl implements NavigationDao {

    @Autowired
    NavigationRepository navigationRepository;

    @Override
    public NavigationDto getNavigationDetails(String clientId, String module,
                                              List<String> roleNames){
        Navigation navigation = null;
        if (null != roleNames){
             navigation = navigationRepository.getNavigationDetails(clientId, module, roleNames);
        } else {
            navigation = navigationRepository.getNavigationDetails(clientId, module);
        }

        return modelMapper.map(navigation, NavigationDto.class);
    }
}
