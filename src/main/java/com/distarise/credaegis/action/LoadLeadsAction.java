package com.distarise.credaegis.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.dao.WorkDao;
import com.distarise.credaegis.enumerations.LeadStatus;
import com.distarise.credaegis.model.CredaegisContextDto;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import com.distarise.credaegis.model.WorkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LoadLeadsAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    WorkDao workDao;

    @Override
    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach( navigationItemDto -> {
            navigationItemDto.getWidgets().forEach(widgetDto ->  {
                Optional<ComponentDto> status = ComponentDto.filterComponentDtoById(widgetDto.getComponentDtos(),"status");
                List<WorkDto> workDtoList = workDao.getWorkByStatus(status.get().getValue());
                if (widgetDto.getId().equalsIgnoreCase("leadsgrid")){
                    widgetDto.getComponentDtos().forEach(targetComponentDto -> {
                        if (targetComponentDto.getId().equals("status")){
                            targetComponentDto.setValue(status.get().getValue());
                        }
                        else if (targetComponentDto.getId().equals("leadsgrid")){
                            setWorkDetails(targetComponentDto, workDtoList);
                        }

                    });
                }
            });
        });
    }

    private void setWorkDetails(ComponentDto targetComponentDto, List<WorkDto> workDtoList) {
        List<Map<String, String>> gridDetails = new ArrayList<>();
        workDtoList.forEach(workDto -> {
            Map<String, String> gridRow = new HashMap<>();
            targetComponentDto.getComponentItemDtos().forEach(targetComponentItemDto -> {
                gridRow.put("formid", "leadsgrid");
                switch (targetComponentItemDto.getValue()){
                    case "column1" -> gridRow.put("column1", workDto.getPid().toString());
                    case "column2" -> gridRow.put("column2", workDto.getTitle());
                    case "column3" -> gridRow.put("column3", workDto.getEmployeeName());
                    case "column4" -> gridRow.put("column4", workDto.getReviewDate().toString());
                    case "column5" -> gridRow.put("column5", workDto.getComment());
                }
                targetComponentDto.fillEmptyColumns(gridRow, 6);
            });
            gridDetails.add(gridRow);
        });
        targetComponentDto.setGridValues(gridDetails);
    }
/*

    private void setLeadDetails(ComponentDto componentDto, CredaegisContextDto context){
        PersonDto personDto = context.getPersonDto();
        switch (componentDto.getId()){
            case "name" -> componentDto.setValue(personDto.getFirstName());
            case "gender" -> componentDto.setValue(String.valueOf(personDto.getGender()));
            case "dob" -> componentDto.setValue(personDto.getDob().toString());
            case "contact" -> componentDto.setValue(personDto.getContact());
            case "email" -> componentDto.setValue(personDto.getEmail());
            case "referral" -> componentDto.setValue(personDto.getReferral());
        }

    }
*/

}
