package com.distarise.base.action;

import com.distarise.base.model.ConfigPageDetailsDto;
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
        ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto) request.getSession().getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
        RoleDto roleDto = new RoleDto(roleName, roleDescription, configPageDetailsDto.getClientId());
        roleService.saveRole(roleDto);
    }
}
