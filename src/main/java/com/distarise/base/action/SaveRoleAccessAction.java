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
        String clientId = request.getParameter("column1");
        String roleName = request.getParameter("column2");
        String widgetId = request.getParameter("column3");
        String action = request.getParameter("column4");
        RoleWidgetActionDto roleWidgetActionDto = new RoleWidgetActionDto(clientId, roleName, widgetId, action, null, true);
        roleService.saveRoleWidgetAction(roleWidgetActionDto);
    }
}
