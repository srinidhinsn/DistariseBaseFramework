package com.distarise.base.dao.impl;

import com.distarise.base.dao.NavigationDao;
import com.distarise.base.entity.Navigation;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.repository.NavigationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NavigationDaoImpl implements NavigationDao {

    @Autowired
    NavigationRepository navigationRepository;

    @Override
    public NavigationDto getNavigationDetails(String clientId, String module,
                                              List<String> roleNames){
        Navigation navigation = null;
        if (null != roleNames){
             navigation = navigationRepository.getNavigationDetails(module, clientId
                    , roleNames);
        } else {
            navigation = navigationRepository.getNavigationDetails(module, clientId);
        }

        return modelMapper.map(navigation, NavigationDto.class);
    }
}
