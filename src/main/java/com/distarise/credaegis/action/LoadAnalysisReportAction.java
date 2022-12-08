package com.distarise.credaegis.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.credaegis.dao.PersonDao;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoadAnalysisReportAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private PersonDao personDao;

    @Override
    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        String personId = request.getParameter("identifier");
        PersonDto personDto = personDao.findByPid(Long.parseLong(personId));
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach( navigationItemDto -> {
            navigationItemDto.getWidgets().forEach(widgetDto ->  {
                if (widgetDto.getId().equalsIgnoreCase("leaddetails")){
                    widgetDto.getComponentDtos().forEach(targetComponentDto -> {
                        setLeadDetails(targetComponentDto, personDto);
                    });
                } else if (widgetDto.getId().equalsIgnoreCase("analysisreport")){
                    widgetDto.getComponentDtos().forEach(targetComponentDto -> {
                        setAnalysisReport(targetComponentDto, personDto.getLeadDtoList());
                    });
                }
            });
        });

    }

    private void setLeadDetails(ComponentDto componentDto, PersonDto personDto){
        switch (componentDto.getId()){
            case "name" -> componentDto.setValue(personDto.getFirstName());
            case "gender" -> componentDto.setValue(String.valueOf(personDto.getGender()));
            case "dob" -> componentDto.setValue(null == personDto.getDob()? "": personDto.getDob().toString());
            case "contact" -> componentDto.setValue(personDto.getContact());
            case "email" -> componentDto.setValue(personDto.getEmail());
            case "referral" -> componentDto.setValue(personDto.getReferral());
        }

    }

    private void setAnalysisReport(ComponentDto componentDto, List<LeadDto> leadDtos){
        List<Map<String, String>> gridDetails = new ArrayList<>();
        leadDtos.forEach(leadDto -> {
            Map<String, String> gridRow = new HashMap<>();
            componentDto.getComponentItemDtos().forEach(targetComponentItemDto -> {
                gridRow.put("formid", "creditreport");
                switch (targetComponentItemDto.getValue()){
                    case "column1" -> gridRow.put("column1", leadDto.getAccountName());
                    case "column2" -> gridRow.put("column2", leadDto.getAccountNo());
                    case "column3" -> gridRow.put("column3", leadDto.getAccountType());
                    case "column4" -> gridRow.put("column4", leadDto.getProblemStatement());
                    case "column5" -> gridRow.put("column5", leadDto.getAmountOverdue().toString());
                    case "column6" -> gridRow.put("column6", leadDto.getCreditStatus());
                    case "column7" -> gridRow.put("column7", leadDto.getCurrentBalance().toString());
                }
                componentDto.fillEmptyColumns(gridRow, 8);
            });
            gridDetails.add(gridRow);
        });
        componentDto.setGridValues(gridDetails);
    }


}
