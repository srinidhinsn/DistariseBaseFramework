package com.distarise.base.actionextension;

import com.distarise.base.action.LoadClientListAction;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.ComponentItemService;
import com.distarise.base.service.ComponentService;
import com.distarise.base.service.NavigationItemService;
import com.distarise.base.service.NavigationService;
import com.distarise.base.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoadNavigationItemActionExt {

    @Autowired
    NavigationService navigationService;

    @Autowired
    NavigationItemService navigationItemService;

    @Autowired
    WidgetService widgetService;

    @Autowired
    ComponentService componentService;

    @Autowired
    ComponentItemService componentItemService;

    public List<ComponentItemDto> preloadNavigationList(String clientId, String selectedUiNav) {
        if (clientId.equalsIgnoreCase("new") || clientId.isEmpty()){
            return null;
        }

        List<NavigationDto> navigationDtoList = navigationService.getAllNavigations(clientId);
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();
        for (int i=0; i<navigationDtoList.size(); i++) {
            ComponentItemDto componentItemDto = new ComponentItemDto(30000L+i,
                    "landingpage", clientId , i+1,
                    navigationDtoList.get(i).getId(), navigationDtoList.get(i).getId(), false, true
            );
            if (componentItemDto.getValue().equals(selectedUiNav)){
                componentItemDto.setSelected(true);
            }
            componentItemDtoList.add(componentItemDto);
        }
        return componentItemDtoList;
    }

    public void preloadNavigationItemForm(HttpServletRequest request, String clientId, ComponentDto componentDto) {
        if (clientId.isEmpty() || clientId.equalsIgnoreCase("new")){
            return;
        }
        String selectedUiNav = request.getParameter("landingpage");
        List<NavigationItemDto> navigationItemDtoList = navigationItemService.getNavigationItems(selectedUiNav);
        List<Map<String, String>> gridDetails = new ArrayList<>();
        navigationItemDtoList.forEach(navigationItemDto -> {
            Map<String, String> gridRow = new HashMap<>();
            gridRow.put("formid", "savenavigationitem");
            componentDto.getComponentItemDtos().forEach(componentItemDto -> {
                if (componentItemDto.getValue().equalsIgnoreCase("column2")){
                    gridRow.put(componentItemDto.getValue(), navigationItemDto.getId());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column3")){
                    gridRow.put(componentItemDto.getValue(), navigationItemDto.getLabel());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column4")){
                    gridRow.put(componentItemDto.getValue(), navigationItemDto.getSortOrder().toString());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column5")){
                    gridRow.put(componentItemDto.getValue(), navigationItemDto.getUrl());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column6")){
                    gridRow.put(componentItemDto.getValue(), navigationItemDto.getLayoutId());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column7")){
                    gridRow.put(componentItemDto.getValue(), navigationItemDto.getNavigationItemId());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column8")){
                    gridRow.put(componentItemDto.getValue(), clientId);
                } else if (componentItemDto.getValue().equalsIgnoreCase("column9")){
                    gridRow.put(componentItemDto.getValue(), selectedUiNav);
                }
            });
            componentDto.fillEmptyColumns(gridRow, 10);
            gridDetails.add(gridRow);
        });
        componentDto.setGridValues(gridDetails);
    }

    public List<ComponentItemDto> preloadNavItemList(String clientId, HttpServletRequest request){
        if (clientId.equalsIgnoreCase("new") || clientId.isEmpty()){
            return null;
        }
        String selectedUiNav = request.getParameter("landingpage");
        String selectedUiNavItem = request.getParameter("navigationitemlist");
        List<NavigationItemDto> navigationItemDtoList = navigationItemService.getNavigationItems(selectedUiNav);
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();

        for (int i=0; i<navigationItemDtoList.size(); i++) {
            ComponentItemDto componentItemDto = new ComponentItemDto(60000L + i,
                    "navigationitemlist", clientId, i + 1,
                    navigationItemDtoList.get(i).getId(), navigationItemDtoList.get(i).getId(), false, true
            );
            if (componentItemDto.getValue().equals(selectedUiNavItem)) {
                componentItemDto.setSelected(true);
            }
            componentItemDtoList.add(componentItemDto);
        }
        return componentItemDtoList;
    }

    public void preloadWidgetForm(HttpServletRequest request, String clientId, ComponentDto componentDto) {
        if (clientId.isEmpty() || clientId.equalsIgnoreCase("new")){
            return;
        }
        String selectedUiNav = request.getParameter("landingpage");
        String selectedUiNavItem = request.getParameter("navigationitemlist");
        List<WidgetDto> widgetDtoList = widgetService.getWidgetByNavigationItemId(clientId, selectedUiNavItem);

        List<Map<String, String>> gridDetails = new ArrayList<>();
        widgetDtoList.forEach(widgetDto -> {
            Map<String, String> gridRow = new HashMap<>();
            gridRow.put("formid", "savewidget");
            componentDto.getComponentItemDtos().forEach(componentItemDto -> {
                if (componentItemDto.getValue().equalsIgnoreCase("column2")){
                    gridRow.put(componentItemDto.getValue(), widgetDto.getId());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column3")){
                    gridRow.put(componentItemDto.getValue(), widgetDto.getWidgetTitle());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column4")){
                    gridRow.put(componentItemDto.getValue(), widgetDto.getSortOrder().toString());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column5")){
                    gridRow.put(componentItemDto.getValue(), widgetDto.getNavigationItemId());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column6")){
                    gridRow.put(componentItemDto.getValue(), widgetDto.getWidgetId());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column7")){
                    gridRow.put(componentItemDto.getValue(), widgetDto.getLayoutId());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column8")){
                    gridRow.put(componentItemDto.getValue(), widgetDto.getCssClass());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column9")){
                    gridRow.put(componentItemDto.getValue(), clientId);
                } else if (componentItemDto.getValue().equalsIgnoreCase("column10")){
                    gridRow.put(componentItemDto.getValue(), selectedUiNav);
                } else if (componentItemDto.getValue().equalsIgnoreCase("column11")){
                    gridRow.put(componentItemDto.getValue(), selectedUiNavItem);
                }
            });
            componentDto.fillEmptyColumns(gridRow, 12);
            gridDetails.add(gridRow);
        });
        componentDto.setGridValues(gridDetails);
    }

    public List<ComponentItemDto> preloadWidgetList(String clientId, HttpServletRequest request){
        if (clientId.equalsIgnoreCase("new") || clientId.isEmpty()){
            return null;
        }
        String selectedUiNavItem = request.getParameter("navigationitemlist");
        String selectedWidget = request.getParameter("widgetlist");
        List<WidgetDto> widgetDtoList = widgetService.getWidgetByNavigationItemId(clientId, selectedUiNavItem);
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();

        for (int i=0; i<widgetDtoList.size(); i++) {
            ComponentItemDto componentItemDto = new ComponentItemDto(90000L + i,
                    "widgetlist", clientId, i + 1,
                    widgetDtoList.get(i).getId(), widgetDtoList.get(i).getId(), false, true
            );
            if (componentItemDto.getValue().equals(selectedWidget)) {
                componentItemDto.setSelected(true);
            }
            componentItemDtoList.add(componentItemDto);
        }
        return componentItemDtoList;
    }

    public void preloadComponentForm(HttpServletRequest request, String clientId, ComponentDto componentDto) {
        if (clientId.isEmpty() || clientId.equalsIgnoreCase("new")){
            return;
        }
        String selectedUiNav = request.getParameter("landingpage");
        String selectedUiNavItem = request.getParameter("navigationitemlist");
        String selectedWidget = request.getParameter("widgetlist");
        List<ComponentDto> componentDtoList = componentService.getComponentsByWidgetId(clientId, selectedWidget);

        List<Map<String, String>> gridDetails = new ArrayList<>();
        componentDtoList.forEach(targetComponentDto -> {
            Map<String, String> gridRow = new HashMap<>();
            gridRow.put("formid", "savecomponent");
            componentDto.getComponentItemDtos().forEach(componentItemDto -> {
                if (componentItemDto.getValue().equalsIgnoreCase("column1")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getId());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column2")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getEditable().toString());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column3")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getLabel());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column4")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getValue());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column5")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getKeyOrAction());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column6")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getRedirectUrl());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column7")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getSortOrder().toString());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column8")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getType());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column9")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getVisible().toString());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column10")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getMultiLevel().toString());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column11")){
                    gridRow.put(componentItemDto.getValue(), targetComponentDto.getWidgetId());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column12")){
                    gridRow.put(componentItemDto.getValue(), clientId);
                } else if (componentItemDto.getValue().equalsIgnoreCase("column13")){
                    gridRow.put(componentItemDto.getValue(), selectedUiNav);
                } else if (componentItemDto.getValue().equalsIgnoreCase("column14")){
                    gridRow.put(componentItemDto.getValue(), selectedUiNavItem);
                }
            });
            componentDto.fillEmptyColumns(gridRow, 15);
            gridDetails.add(gridRow);
        });
        componentDto.setGridValues(gridDetails);
    }

    public List<ComponentItemDto> preloadComponentList(String clientId, HttpServletRequest request){
        if (clientId.equalsIgnoreCase("new") || clientId.isEmpty()){
            return null;
        }
        String selectedComponent = request.getParameter("componentlist");
        String selectedWidget = request.getParameter("widgetlist");
        List<ComponentDto> sourceComponentDtoList = componentService.getMultilevelComponentsByWidgetId(clientId, selectedWidget);
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();

        for (int i=0; i<sourceComponentDtoList.size(); i++) {
            ComponentItemDto componentItemDto = new ComponentItemDto(140000L + i,
                    "componentlist", clientId, i + 1,
                    sourceComponentDtoList.get(i).getId(), sourceComponentDtoList.get(i).getLabel(), false, true
            );
            if (componentItemDto.getValue().equals(selectedComponent)) {
                componentItemDto.setSelected(true);
            }
            componentItemDtoList.add(componentItemDto);
        }
        return componentItemDtoList;
    }

    public void preloadComponentItemForm(HttpServletRequest request, String clientId, ComponentDto componentDto) {
        if (clientId.isEmpty() || clientId.equalsIgnoreCase("new")){
            return;
        }

        String selectedComponent = request.getParameter("componentlist");
        List<ComponentItemDto> componentItemDtoList = componentItemService.getComponentItemsByComponentId(clientId, selectedComponent);

        List<Map<String, String>> gridDetails = new ArrayList<>();
        componentItemDtoList.forEach(targetComponentItemDto -> {
            Map<String, String> gridRow = new HashMap<>();
            gridRow.put("formid", "savecomponentitem");
            componentDto.getComponentItemDtos().forEach(componentItemDto -> {
                if (componentItemDto.getValue().equalsIgnoreCase("column2")){
                    gridRow.put(componentItemDto.getValue(), clientId);
                } else if (componentItemDto.getValue().equalsIgnoreCase("column3")){
                    gridRow.put(componentItemDto.getValue(), selectedComponent);
                } else if (componentItemDto.getValue().equalsIgnoreCase("column4")){
                    gridRow.put(componentItemDto.getValue(), targetComponentItemDto.getId().toString());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column5")){
                    gridRow.put(componentItemDto.getValue(), targetComponentItemDto.getEditable().toString());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column6")){
                    gridRow.put(componentItemDto.getValue(), targetComponentItemDto.getLabel());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column7")){
                    gridRow.put(componentItemDto.getValue(), targetComponentItemDto.getSortOrder().toString());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column8")){
                    gridRow.put(componentItemDto.getValue(), targetComponentItemDto.getValue());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column9")){
                    gridRow.put(componentItemDto.getValue(), targetComponentItemDto.getVisible().toString());
                }
            });
            componentDto.fillEmptyColumns(gridRow, 10);
            gridDetails.add(gridRow);
        });
        componentDto.setGridValues(gridDetails);
    }


}
