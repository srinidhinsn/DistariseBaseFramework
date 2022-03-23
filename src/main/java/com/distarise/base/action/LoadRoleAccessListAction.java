package com.distarise.base.action;

import com.distarise.base.actionextension.LoadUserRoleAccessActionExt;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.RoleDto;
import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.service.ComponentService;
import com.distarise.base.service.RoleService;
import com.distarise.base.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadRoleAccessListAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private RoleService roleService;

    @Autowired
    private WidgetService widgetService;

    @Autowired
    private ComponentService componentService;

    @Autowired
    private LoadUserRoleAccessActionExt loadUserRoleAccessActionExt;

    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        ConfigPageDetailsDto configPageDetailsDto = loadUserRoleAccessActionExt.setConfigPageDetails(request, getClientId());
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    List<RoleWidgetActionDto> enabledRoleWidgetActionDtos = roleService.findAllByClientId(configPageDetailsDto.getClientId());
                    List<RoleWidgetActionDto> allRoleWidgetActions = componentService.getActionsByClientIdAndRoleName(configPageDetailsDto.getClientId(), configPageDetailsDto.getRoleName());
                    loadUserRoleAccessActionExt.updateAllRoleWidgetActions(allRoleWidgetActions, enabledRoleWidgetActionDtos);
                    if (targetWidgetDto.getId().equalsIgnoreCase("addroleaccess") ){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("rolelist")){
                                List<RoleDto> roleDtoList = roleService.getRoleList(configPageDetailsDto.getClientId());
                                List<ComponentItemDto> componentItemDtoList = loadUserRoleAccessActionExt.preloadRoleList(roleDtoList, configPageDetailsDto);
                                if (null != componentItemDtoList){
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            } else if(targetComponentDto.getId().equalsIgnoreCase("roleaccessgrid")){
                                loadUserRoleAccessActionExt.preloadRoleAccessGrid(targetComponentDto, allRoleWidgetActions);
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
