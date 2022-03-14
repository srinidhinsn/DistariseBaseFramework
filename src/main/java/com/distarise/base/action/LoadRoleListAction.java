package com.distarise.base.action;

import com.distarise.base.actionextension.LoadClientDetailsActionExt;
import com.distarise.base.actionextension.LoadUserRoleAccessActionExt;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.RoleDto;
import com.distarise.base.service.ClientService;
import com.distarise.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadRoleListAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private RoleService roleService;

    @Autowired
    private LoadUserRoleAccessActionExt loadUserRoleAccessActionExt;

    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("addrole")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("rolelist")){
                                List<RoleDto> roleDtoList = roleService.getRoleList(targetPageDetailsDto.getClientDto().getId());
                                List<ComponentItemDto> componentItemDtoList = loadUserRoleAccessActionExt.preloadRoleList(request, roleDtoList);
                                if (null != componentItemDtoList){
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }

                                loadUserRoleAccessActionExt.preloadRoleForm(request, targetWidgetDto, roleDtoList, request.getParameter("rolelist"));
                            } else if(targetComponentDto.getId().equalsIgnoreCase("clientid")){{
                                targetComponentDto.setValue(targetPageDetailsDto.getClientDto().getId());
                            }}
                        });
                    }
                });
            }
        });

    }
}
