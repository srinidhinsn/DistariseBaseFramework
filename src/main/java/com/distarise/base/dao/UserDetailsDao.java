package com.distarise.base.dao;

import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.UserRoleDto;

import java.util.List;

public interface UserDetailsDao extends AbstractBaseDao {
    UserDetailsDto getUserDetails(String userId, String password, String clientId);
    List<UserRoleDto> getUserRoles(String userId, String clientId);
}
