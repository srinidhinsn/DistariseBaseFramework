package com.distarise.base.service.impl;

import com.distarise.base.dao.RoleDao;
import com.distarise.base.model.RoleDto;
import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<RoleDto> getRoleList(String client) {
        return roleDao.getRoleList(client);
    }

    @Override
    public void saveRole(RoleDto roleDto) {
        roleDao.saveRole(roleDto);
    }

    @Override
    public void saveRoleWidgetAction(RoleWidgetActionDto roleWidgetActionDto) {
        roleDao.saveRoleWidgetAction(roleWidgetActionDto);
    }
}
