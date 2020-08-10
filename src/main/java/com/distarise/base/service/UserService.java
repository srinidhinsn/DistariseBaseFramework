package com.distarise.base.service;

import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.UserRoleDto;

public interface UserService extends BaseService {
    UserDetailsDto getUserDetails(String userId, String password);
    PageDetailsDto getPageDetails(BaseContextDto baseContextDto);
}
