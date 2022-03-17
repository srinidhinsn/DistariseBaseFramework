package com.distarise.base.action;

import com.distarise.base.actionextension.LoadUserRoleAccessActionExt;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.RoleDto;
import com.distarise.base.model.WidgetDto;
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
                    List<ComponentDto> componentDtoList = componentService.getActionsByClientId(configPageDetailsDto.getClientId());
                    if (targetWidgetDto.getId().equalsIgnoreCase("addroleaccess") ){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("rolelist")){
                                List<RoleDto> roleDtoList = roleService.getRoleList(configPageDetailsDto.getClientId());
                                List<ComponentItemDto> componentItemDtoList = loadUserRoleAccessActionExt.preloadRoleList(roleDtoList, configPageDetailsDto);
                                if (null != componentItemDtoList){
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            } else if(targetComponentDto.getId().equalsIgnoreCase("widgetlist")){
                                List<WidgetDto> widgetDtoList = widgetService.getWidgetsByClientId(configPageDetailsDto.getClientId());
                                List<ComponentItemDto> componentItemDtoList = loadUserRoleAccessActionExt.preloadWidgetList(widgetDtoList, configPageDetailsDto);
                                if (null != componentItemDtoList){
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            } else if(targetComponentDto.getId().equalsIgnoreCase("actionlist")){
                                List<ComponentItemDto> componentItemDtoList = loadUserRoleAccessActionExt.preloadAccessList(componentDtoList, configPageDetailsDto);
                                if (null != componentItemDtoList){
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            } else if(targetComponentDto.getId().equalsIgnoreCase("roleaccessgrid")){
                                loadUserRoleAccessActionExt.preloadRoleAccessGrid(targetComponentDto, componentDtoList, configPageDetailsDto);
                            } else if(targetComponentDto.getId().equalsIgnoreCase("clientid")){
                                targetComponentDto.setValue(configPageDetailsDto.getClientId());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("clientlist")){
                                targetComponentDto.getComponentItemDtos().addAll(
                                        loadUserRoleAccessActionExt.addAllClients(configPageDetailsDto)
                                );

                            }
                        });
                    } else if (targetWidgetDto.getId().equalsIgnoreCase("saveroleaccess")){
                        loadUserRoleAccessActionExt.preloadRoleAccessForm(targetWidgetDto, configPageDetailsDto);
                    }
                });
            }
        });

    }
}
