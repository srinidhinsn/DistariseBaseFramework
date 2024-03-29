package com.distarise.base.service;

import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.UserRoleDto;

import java.util.List;

public interface UserService extends AbstractBaseService {
    UserDetailsDto getUserDetails(String userId, String password, String clientId);
    List<UserRoleDto> getUserRoles(String userId, String clientId);
    List<RoleWidgetActionDto> getUserRoleWidgetActions(String userId, String clientId);
}
