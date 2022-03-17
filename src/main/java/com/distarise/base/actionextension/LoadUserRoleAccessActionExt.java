package com.distarise.base.actionextension;

import com.distarise.base.action.LoadClientListAction;
import com.distarise.base.dao.RoleDao;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.RoleDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.ClientService;
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
    public List<ComponentItemDto> preloadWidgetList(List<WidgetDto> widgetDtoList, ConfigPageDetailsDto configPageDetailsDto) {
        if (null == widgetDtoList || widgetDtoList.isEmpty()){
            return null;
        }
        String selectedWidget = configPageDetailsDto.getWidgetId();
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();
        for (int i=0; i<widgetDtoList.size(); i++){
            WidgetDto widgetDto = widgetDtoList.get(i);
            ComponentItemDto componentItemDto = new ComponentItemDto(18000L + i, "rolelist", widgetDto.getClientId(),
                    i, widgetDto.getId(), widgetDto.getWidgetTitle(), true, true);
            if (widgetDto.getId().equalsIgnoreCase(selectedWidget)){
                componentItemDto.setSelected(true);
            }
            componentItemDtoList.add(componentItemDto);
        }
        return componentItemDtoList;
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

    public void preloadRoleAccessForm(WidgetDto targetWidgetDto,  ConfigPageDetailsDto configPageDetailsDto) {
        String role = configPageDetailsDto.getRoleName();
        String widget = configPageDetailsDto.getWidgetId();
        String action = configPageDetailsDto.getAction();
        String clientId = configPageDetailsDto.getClientId();
        targetWidgetDto.getComponentDtos().forEach(componentDto -> {
            if (componentDto.getId().equalsIgnoreCase("column1")){
                componentDto.setValue(clientId);
            }else if (componentDto.getId().equalsIgnoreCase("column2")){
                componentDto.setValue(role);
            }else if (componentDto.getId().equalsIgnoreCase("column3")){
                componentDto.setValue(widget);
            }else if (componentDto.getId().equalsIgnoreCase("column4")){
                if (null != action){
                    componentDto.setValue(action);
                }
            }
        });
    }

    public List<ComponentItemDto> preloadAccessList(List<ComponentDto> componentDtoList, ConfigPageDetailsDto configPageDetailsDto) {
        if (null == componentDtoList || componentDtoList.isEmpty()){
            return null;
        }
        String selectedAction = configPageDetailsDto.getAction();
        String clientId = configPageDetailsDto.getClientId();
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();
        for (int i=0; i<componentDtoList.size(); i++){
            ComponentDto componentDto = componentDtoList.get(i);
            if (null != componentDto.getKeyOrAction() && !componentDto.getKeyOrAction().isEmpty()) {
                ComponentItemDto componentItemDto = new ComponentItemDto(18000L + i, "accesslist", clientId,
                        i, componentDto.getKeyOrAction(), componentDto.getId(), true, true);
                if (componentDto.getKeyOrAction().equalsIgnoreCase(selectedAction)) {
                    componentItemDto.setSelected(true);
                }
                componentItemDtoList.add(componentItemDto);
            }
        }
        return componentItemDtoList;
    }

    public void preloadRoleAccessGrid(ComponentDto targetComponentDto, List<ComponentDto> componentDtoList, ConfigPageDetailsDto configPageDetailsDto) {
        String selectedAction = configPageDetailsDto.getAction();
        String selectedWidget = configPageDetailsDto.getWidgetId();
        String selectedRole = configPageDetailsDto.getRoleName();
        String clientId = configPageDetailsDto.getClientId();
        List<Map<String, String>> gridList = new ArrayList<>();

        componentDtoList.forEach(componentDto -> {
            if (componentDto.getWidgetId().equalsIgnoreCase(selectedWidget)) {
                Map<String, String> gridRow = new HashMap<>();
                targetComponentDto.getComponentItemDtos().forEach(componentItemDto -> {
                    gridRow.put("formid", "saveroleaccess");
                    if (componentItemDto.getValue().equalsIgnoreCase("column1")) {
                        gridRow.put(componentItemDto.getValue(), clientId);
                    } else if (componentItemDto.getValue().equalsIgnoreCase("column2")) {
                        gridRow.put(componentItemDto.getValue(), selectedRole);
                    } else if (componentItemDto.getValue().equalsIgnoreCase("column3")) {
                        gridRow.put(componentItemDto.getValue(), componentDto.getWidgetId());
                    } else if (componentItemDto.getValue().equalsIgnoreCase("column4")) {
                        gridRow.put(componentItemDto.getValue(), componentDto.getKeyOrAction());
                    }
                });
                componentDto.fillEmptyColumns(gridRow, 5);
                gridList.add(gridRow);
            }
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
        if (null == clientId){
            configPageDetailsDto.setClientId(defaultClientId);
        }
        else {
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
}
