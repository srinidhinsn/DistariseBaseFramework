package com.distarise.base.dao;

import com.distarise.base.model.RoleWidgetActionDto;

import java.util.List;

public interface UserRoleDao extends AbstractBaseDao {
    List<RoleWidgetActionDto> getUserRoleWidgetActions(String userId, String clientId);
}
