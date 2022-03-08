package com.distarise.base.actionextension;

import com.distarise.base.action.LoadClientListAction;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.NavigationItemService;
import com.distarise.base.service.NavigationService;
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

    public List<ComponentItemDto> preloadNavigationList(String clientId) {
        if (clientId.equalsIgnoreCase("new") || clientId.isEmpty()){
            return null;
        }

        List<NavigationDto> navigationDtoList = navigationService.getAllNavigations(clientId);
        List<ComponentItemDto> componentItemDtoList = new ArrayList<>();
        for (int i=0; i<navigationDtoList.size(); i++) {
            componentItemDtoList.add(new ComponentItemDto(30000L+i,
                    "landingpage", "distarise" , i+1,
                    navigationDtoList.get(i).getId(), navigationDtoList.get(i).getId(), false, true
            ));
        }
        return componentItemDtoList;
    }

    public void preloadNavigationItemForm(HttpServletRequest request, WidgetDto targetWidgetDto) {
        String selectedUiNav = request.getParameter("landingpage");
        List<NavigationItemDto> navigationItemDtoList = navigationItemService.getNavigationItems(selectedUiNav);
        targetWidgetDto.getComponentDtos().forEach(componentDto -> {
            if(componentDto.getId().equalsIgnoreCase("id")){
                componentDto.setValue();
            }
        });
    }
}
