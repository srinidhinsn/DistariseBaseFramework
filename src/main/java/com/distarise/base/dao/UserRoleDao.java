package com.distarise.base.dao;

import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.UserRoleDto;

import java.util.List;

public interface UserRoleDao extends AbstractBaseDao {
    List<RoleWidgetActionDto> getUserRoleWidgetActions(String userId, String clientId);
    List<UserRoleDto> getAllUserRolesByClientId(String clientId);
    void saveUserRoleDetails(UserDetailsDto userDetailsDto);
}
