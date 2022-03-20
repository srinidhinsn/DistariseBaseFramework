package com.distarise.base.actionextension;

import com.distarise.base.action.LoadClientListAction;
import com.distarise.base.dao.RoleDao;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.RoleDto;
import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.ClientService;
import com.distarise.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoadUserRoleAccessActionExt {

    @Autowired
    private ClientService clientService;

    public void preloadRoleForm(HttpServletRequest request, WidgetDto targetWidgetDto,
                                List<RoleDto> roleDtoList, String roleName) {
        if (null != roleName && !roleName.isEmpty() && !roleName.equalsIgnoreCase("new")){

            RoleDto roleDtoToLoad = roleDtoList.stream().filter(
                    roleDto -> roleDto.getRoleName().equals(roleName)).collect(Collectors.toList()).get(0);
            targetWidgetDto.getComponentDtos().forEach(componentDto -> {
                if (componentDto.getId().equals("rolename")) {
                    componentDto.setValue(roleDtoToLoad.getRoleName());
                } else if (componentDto.getId().equals("roledescription")) {
                    componentDto.setValue(roleDtoToLoad.getDescription());
                } else if (componentDto.getId().equals("clientid")) {
                    componentDto.setValue(roleDtoToLoad.getClientId());
                }

            });
        }

    }


    public List<ComponentItemDto> preloadRoleList(List<RoleDto> roleDtoList, ConfigPageDetailsDto configPageDetailsDto){
        if (null == roleDtoList || roleDtoList.isEmpty()){
            return null;
        }
        String selectedRole =  configPageDetailsDto.getRoleName();
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();
        for (int i=0; i<roleDtoList.size(); i++){
            RoleDto roleDto = roleDtoList.get(i);
            ComponentItemDto componentItemDto = new ComponentItemDto(17000L + i, "rolelist", roleDto.getClientId(),
                    i, roleDto.getRoleName(), roleDto.getDescription(), true, true);
            if (roleDto.getRoleName().equalsIgnoreCase(selectedRole)){
                componentItemDto.setSelected(true);
            }
            componentItemDtoList.add(componentItemDto);
        }
        return componentItemDtoList;
    }

    public void preloadRoleAccessGrid(ComponentDto targetComponentDto, List<RoleWidgetActionDto> roleWidgetActionDtos ) {
        List<Map<String, String>> gridList = new ArrayList<>();

        roleWidgetActionDtos.forEach(roleWidgetActionDto -> {
            Map<String, String> gridRow = new HashMap<>();
            gridRow.put("enabled", roleWidgetActionDto.getEnabled().toString().toLowerCase());
            gridRow.put("roleName", roleWidgetActionDto.getRoleName());
            gridRow.put("widgetId", roleWidgetActionDto.getWidgetId());
            gridRow.put("action", roleWidgetActionDto.getAction());
            gridRow.put("clientId", roleWidgetActionDto.getClientId());
            gridList.add(gridRow);
        });

        targetComponentDto.setGridValues(gridList);
    }

    public ConfigPageDetailsDto setConfigPageDetails(HttpServletRequest request, String defaultClientId) {
        ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto) request.getSession().
                getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
        String clientId = request.getParameter("clientlist");
        String roleName = request.getParameter("rolelist");
        String widgetId = request.getParameter("widgetlist");
        String action = request.getParameter("actionlist");
        if (null == configPageDetailsDto) {
            configPageDetailsDto = new ConfigPageDetailsDto();
            request.getSession().setAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS, configPageDetailsDto);
        }
        if (null == clientId && null == configPageDetailsDto.getClientId()){
            configPageDetailsDto.setClientId(defaultClientId);
        }
        if (null != clientId) {
            configPageDetailsDto.setClientId(clientId);
        }
        if (null != roleName){
            configPageDetailsDto.setRoleName(roleName);
        }
        if (null != widgetId){
            configPageDetailsDto.setWidgetId(widgetId);
        }
        if (null != action){
            configPageDetailsDto.setAction(action);
        }

        return configPageDetailsDto;
    }

    public Collection<? extends ComponentItemDto> addAllClients(ConfigPageDetailsDto configPageDetailsDto) {
        List<ClientDto> clientDtoList = clientService.getAllClients();
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();
        for (int i=0; i < clientDtoList.size(); i++){
            ComponentItemDto componentItemDto = new ComponentItemDto(23000L+i,
                    "clientlist", "distarise" , i+1,
                    clientDtoList.get(i).getId(), clientDtoList.get(i).getHeader(), false, true
            );
            if (configPageDetailsDto.getClientId().equals(clientDtoList.get(i).getId())){
                componentItemDto.setSelected(true);
            }
            componentItemDtoList.add(componentItemDto);
        }
        return componentItemDtoList;
    }

    public void updateAllRoleWidgetActions(List<RoleWidgetActionDto> allRoleWidgetActions, List<RoleWidgetActionDto> enabledRoleWidgetActionDtos) {
        for (int i=0; allRoleWidgetActions.size()>i; i++){
            for (int j=0; enabledRoleWidgetActionDtos.size()>j; j++){
                if (allRoleWidgetActions.get(i).equals(enabledRoleWidgetActionDtos.get(j))){
                    allRoleWidgetActions.get(i).setEnabled(enabledRoleWidgetActionDtos.get(j).getEnabled());
                    break;
                }
            }
        }
    }
}
