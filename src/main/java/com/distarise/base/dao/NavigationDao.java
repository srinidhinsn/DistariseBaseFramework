package com.distarise.base.dao;

import com.distarise.base.model.NavigationDto;

import java.util.List;

public interface NavigationDao extends AbstractBaseDao {
    NavigationDto getNavigationDetails(String clientId, String module, String roleName);
    List<NavigationDto> getAllNavigations(String clientId);
    void saveNavigationDetails(NavigationDto navigationDto);
}
