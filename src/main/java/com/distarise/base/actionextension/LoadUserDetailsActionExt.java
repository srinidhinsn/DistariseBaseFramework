package com.distarise.base.actionextension;

import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.UserDetailsDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoadUserDetailsActionExt {

    public void preloadUserDetailsForm(ComponentDto targetComponentDto, List<UserDetailsDto> userDetailsDtoList) {
        if (null == userDetailsDtoList || userDetailsDtoList.isEmpty()){
            return;
        }

        List<Map<String, String>> gridDetails = new ArrayList<>();
        userDetailsDtoList.forEach(userDetailsDto -> {
            Map<String, String> gridRow = new HashMap<>();
            targetComponentDto.getComponentItemDtos().forEach(componentItemDto -> {
                gridRow.put("formid", "saveuser");
                if (componentItemDto.getValue().equalsIgnoreCase("column1")){
                    gridRow.put(componentItemDto.getValue(), userDetailsDto.getTitle());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column2")){
                    gridRow.put(componentItemDto.getValue(), userDetailsDto.getUserId());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column3")){
                    gridRow.put(componentItemDto.getValue(), userDetailsDto.getFirstname());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column4")){
                    gridRow.put(componentItemDto.getValue(), userDetailsDto.getLastname());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column5")){
                    gridRow.put(componentItemDto.getValue(), userDetailsDto.getPassword());
                } else if (componentItemDto.getValue().equalsIgnoreCase("column6")){
                    gridRow.put(componentItemDto.getValue(), userDetailsDto.getRoleName());
                }
            });
            targetComponentDto.fillEmptyColumns(gridRow, 7);
            gridDetails.add(gridRow);
        });
        targetComponentDto.setGridValues(gridDetails);
    }
}
