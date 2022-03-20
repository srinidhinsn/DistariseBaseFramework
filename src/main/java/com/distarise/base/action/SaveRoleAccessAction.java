package com.distarise.base.action;

import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.RoleDto;
import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveRoleAccessAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private RoleService roleService;

    public void executeAction() {
        ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto) request.getSession().getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
        String clientId = request.getParameter("selectedClientId");
        String roleName = request.getParameter("selectedRoleName");
        String widgetId = request.getParameter("selectedWidgetId");
        String action = request.getParameter("selectedRoleAction");
        Boolean enabled = Boolean.parseBoolean(request.getParameter("selectedEnabled"));

        RoleWidgetActionDto roleWidgetActionDto = new RoleWidgetActionDto(clientId, roleName, widgetId, action, enabled, true);
        roleService.saveRoleWidgetAction(roleWidgetActionDto);
    }
}
