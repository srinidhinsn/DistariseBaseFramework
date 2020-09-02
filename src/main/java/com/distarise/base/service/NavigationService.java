package com.distarise.base.service;

import com.distarise.base.model.NavigationDto;

public interface NavigationService  extends AbstractBaseService{
    NavigationDto getNavigationDetails(String clientId, String navigationId, String roleName);
}
