package com.distarise.base.action;

import com.distarise.base.model.RoleDto;
import com.distarise.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveRoleAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private RoleService roleService;

    public void executeAction() {
        String roleName = request.getParameter("rolename");
        String roleDescription = request.getParameter("roledescription");
        RoleDto roleDto = new RoleDto(roleName, roleDescription, getClientId());
        roleService.saveRole(roleDto);
    }
}
