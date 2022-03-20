package com.distarise.base.dao;

import com.distarise.base.model.RoleDto;
import com.distarise.base.model.RoleWidgetActionDto;

import java.util.List;

public interface RoleDao extends AbstractBaseDao {
    List<RoleDto> getRoleList(String client);
    void saveRole(RoleDto roleDto);
    void saveRoleWidgetAction(RoleWidgetActionDto roleWidgetActionDto);
    List<RoleWidgetActionDto> findAllByClientId(String clientId);
}
