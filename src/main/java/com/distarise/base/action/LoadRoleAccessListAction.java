package com.distarise.base.action;

import com.distarise.base.actionextension.LoadUserRoleAccessActionExt;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ComponentItemDto;
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
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    List<ComponentDto> componentDtoList = componentService.getActionsByClientId(getClientId());
                    if (targetWidgetDto.getId().equalsIgnoreCase("addroleaccess") ){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("rolelist")){
                                List<RoleDto> roleDtoList = roleService.getRoleList(targetPageDetailsDto.getClientDto().getId());
                                List<ComponentItemDto> componentItemDtoList = loadUserRoleAccessActionExt.preloadRoleList(request, roleDtoList);
                                if (null != componentItemDtoList){
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            } else if(targetComponentDto.getId().equalsIgnoreCase("widgetlist")){
                                List<WidgetDto> widgetDtoList = widgetService.getWidgetsByClientId(getClientId());
                                List<ComponentItemDto> componentItemDtoList = loadUserRoleAccessActionExt.preloadWidgetList(request, widgetDtoList);
                                if (null != componentItemDtoList){
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            } else if(targetComponentDto.getId().equalsIgnoreCase("actionlist")){
                                List<ComponentItemDto> componentItemDtoList = loadUserRoleAccessActionExt.preloadAccessList(request, componentDtoList, getClientId());
                                if (null != componentItemDtoList){
                                    targetComponentDto.getComponentItemDtos().addAll(componentItemDtoList);
                                }
                            } else if(targetComponentDto.getId().equalsIgnoreCase("roleaccessgrid")){
                                loadUserRoleAccessActionExt.preloadRoleAccessGrid(request, targetComponentDto, componentDtoList, getClientId());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("clientid")){{
                                targetComponentDto.setValue(targetPageDetailsDto.getClientDto().getId());
                            }}
                        });
                    } else if (targetWidgetDto.getId().equalsIgnoreCase("saveroleaccess")){
                        loadUserRoleAccessActionExt.preloadRoleAccessForm(request, targetWidgetDto, getClientId());
                    }
                });
            }
        });

    }
}
