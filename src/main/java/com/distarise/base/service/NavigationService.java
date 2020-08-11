package com.distarise.base.service;

import com.distarise.base.model.NavigationDto;
import java.util.List;

public interface NavigationService  extends AbstractBaseService{
    NavigationDto getNavigationDetails(String clientId, String navigationId, List<String> roleNames);
}
