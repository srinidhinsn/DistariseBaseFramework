package com.distarise.base.action;

import com.distarise.base.actionextension.LoadUserRoleAccessActionExt;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.RoleDto;
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
        ConfigPageDetailsDto configPageDetailsDto = loadUserRoleAccessActionExt.setConfigPageDetails(request, getClientId());
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("addrole")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("rolelist")){
                                List<RoleDto> roleDtoList = roleService.getRoleList(configPageDetailsDto.getClientId());
                                List<ComponentItemDto> componentItemDtoList = loadUserRoleAccessActionExt.preloadRoleList(roleDtoList, configPageDetailsDto);
                                if (null != componentItemDtoList){
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }

                                loadUserRoleAccessActionExt.preloadRoleForm(request, targetWidgetDto, roleDtoList, request.getParameter("rolelist"));
                            } else if(targetComponentDto.getId().equalsIgnoreCase("clientid")){
                                targetComponentDto.setValue(configPageDetailsDto.getClientId());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("clientlist")){
                                targetComponentDto.getComponentItemDtos().addAll(
                                        loadUserRoleAccessActionExt.addAllClients(configPageDetailsDto)
                                );
                            }
                        });
                    }
                });
            }
        });

    }


}
