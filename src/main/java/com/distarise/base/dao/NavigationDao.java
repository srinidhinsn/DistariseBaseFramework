package com.distarise.base.dao;

import com.distarise.base.model.NavigationDto;

public interface NavigationDao extends AbstractBaseDao {
    NavigationDto getNavigationDetails(String clientId, String module, String roleName);
}
