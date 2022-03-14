package com.distarise.base.service;

import com.distarise.base.model.RoleDto;
import com.distarise.base.model.RoleWidgetActionDto;

import java.util.List;

public interface RoleService extends AbstractBaseService {
    List<RoleDto> getRoleList(String client);
    void saveRole(RoleDto roleDto);
    void saveRoleWidgetAction(RoleWidgetActionDto roleWidgetActionDto);
}
