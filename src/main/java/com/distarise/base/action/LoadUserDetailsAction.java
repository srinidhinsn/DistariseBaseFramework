package com.distarise.base.action;

import com.distarise.base.actionextension.LoadClientDetailsActionExt;
import com.distarise.base.actionextension.LoadUserDetailsActionExt;
import com.distarise.base.actionextension.LoadUserRoleAccessActionExt;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.RoleDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.UserRoleDto;
import com.distarise.base.service.ClientService;
import com.distarise.base.service.RoleService;
import com.distarise.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoadUserDetailsAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private UserService userService;

    @Autowired
    private LoadUserRoleAccessActionExt loadUserRoleAccessActionExt;

    @Autowired
    private RoleService roleService;

    @Autowired
    private LoadUserDetailsActionExt loadUserDetailsActionExt;

    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        ConfigPageDetailsDto configPageDetailsDto = loadUserRoleAccessActionExt.setConfigPageDetails(request, getClientId());
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("adduser")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("userdetailsgrid")){
                                List<UserDetailsDto> userDetailsDtoList = userService.getAllUserByClientId(configPageDetailsDto.getClientId());
                                List<UserRoleDto> userRoleDtoList = userService.getAllUserRolesByClientId(configPageDetailsDto.getClientId());
                                mapUserRole(userDetailsDtoList, userRoleDtoList);
                                loadUserDetailsActionExt.preloadUserDetailsForm(targetComponentDto, userDetailsDtoList);
                            }
                            else if(targetComponentDto.getId().equalsIgnoreCase("clientid")){
                                targetComponentDto.setValue(configPageDetailsDto.getClientId());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("clientlist")){
                                targetComponentDto.getComponentItemDtos().addAll(
                                        loadUserRoleAccessActionExt.addAllClients(configPageDetailsDto)
                                );
                            }
                        });
                    } else if (targetWidgetDto.getId().equalsIgnoreCase("saveuser")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if (targetComponentDto.getId().equalsIgnoreCase("column6")) {
                                List<RoleDto> roleDtoList = roleService.getRoleList(configPageDetailsDto.getClientId());
                                List<ComponentItemDto> componentItemDtoList = loadUserRoleAccessActionExt.preloadRoleList(roleDtoList, configPageDetailsDto);
                                if (null != componentItemDtoList) {
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            }
                        });
                    }
                });
            }
        });

    }

    private void mapUserRole(List<UserDetailsDto> userDetailsDtoList, List<UserRoleDto> userRoleDtoList){
        userDetailsDtoList.forEach(userDetailsDto -> {
            userRoleDtoList.forEach(userRoleDto -> {
                if (userDetailsDto.getUserId().equals(userRoleDto.getUserId())){
                    userDetailsDto.setRoleName(userDetailsDto.getRoleName()+","+userRoleDto.getRoleName());
                }
            });
            if (null != userDetailsDto.getRoleName() && !userDetailsDto.getRoleName().isEmpty()){
                userDetailsDto.setRoleName(userDetailsDto.getRoleName().replaceFirst("null,",""));
            }
        });
    }
}
