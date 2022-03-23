package com.distarise.base.actionextension;

import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoadNavigationsActionExt {

    @Autowired
    NavigationService navigationService;

    public void preloadNavigationsForm(HttpServletRequest request, ComponentDto componentDto, String clientId) {
        List<NavigationDto> navigationDtoList = new ArrayList<>();
        List<Map<String, String>> gridDetails = new ArrayList<>();

        if (clientId.equalsIgnoreCase("new") || clientId.isEmpty()){
            navigationDtoList.add(new NavigationDto());
        } else {
            navigationDtoList = navigationService.getAllNavigations(clientId);
        }

        navigationDtoList.forEach(navigationDto -> {
            Map<String, String> gridRow = new HashMap<>();
            componentDto.getComponentItemDtos().forEach(componentItemDto -> {
                    gridRow.put("formid", "savenavigation");
                if (componentItemDto.getValue().equalsIgnoreCase("column1")){
                    gridRow.put(componentItemDto.getValue(), clientId);
                } else  if (componentItemDto.getValue().equalsIgnoreCase("column2")){
                    gridRow.put(componentItemDto.getValue(), navigationDto.getId());
                } else  if (componentItemDto.getValue().equalsIgnoreCase("column3")){
                    gridRow.put(componentItemDto.getValue(), navigationDto.getModule());
                } else  if (componentItemDto.getValue().equalsIgnoreCase("column4")){
                    gridRow.put(componentItemDto.getValue(), navigationDto.getPageDescription());
                } else  if (componentItemDto.getValue().equalsIgnoreCase("column5")){
                    gridRow.put(componentItemDto.getValue(), navigationDto.getPageName());
                } else  if (componentItemDto.getValue().equalsIgnoreCase("column6")){
                    gridRow.put(componentItemDto.getValue(), navigationDto.getPageTitle());
                } else  if (componentItemDto.getValue().equalsIgnoreCase("column7")){
                    gridRow.put(componentItemDto.getValue(), navigationDto.getRedirectPageName());
                } else  if (componentItemDto.getValue().equalsIgnoreCase("column8")){
                    gridRow.put(componentItemDto.getValue(), navigationDto.getRoleName());
                }
            });
            componentDto.fillEmptyColumns(gridRow, 9);
            gridDetails.add(gridRow);
        });
        componentDto.setGridValues(gridDetails);

    }
}
