package com.distarise.credaegis.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.dao.PersonDao;
import com.distarise.credaegis.model.CredaegisContextDto;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

        PersonDto personDto = personDao.findByPid(getPidFromRequest(request));

        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach( navigationItemDto -> {
            navigationItemDto.getWidgets().forEach(widgetDto ->  {
                if (widgetDto.getId().equalsIgnoreCase("leaddetails")){
                    widgetDto.getComponentDtos().forEach(targetComponentDto -> {
                        setLeadDetails(targetComponentDto, personDto);
                    });
                } else if (widgetDto.getId().equalsIgnoreCase("analysisreport")){
                    widgetDto.getComponentDtos().forEach(targetComponentDto -> {
                        switch (targetComponentDto.getId()){
                            case "creditreport" -> setAnalysisReport(targetComponentDto, personDto.getLeadDtoList());
                            case "creditscore" -> targetComponentDto.setValue(personDto.getCreditScore().toString());
                            case "pid" -> targetComponentDto.setValue(personDto.getPid().toString());
                        }
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
                    case "column0" -> gridRow.put("column0", leadDto.getLid().toString());
                    case "column1" -> gridRow.put("column1", leadDto.getAccountName());
                    case "column2" -> gridRow.put("column2", leadDto.getAccountNo());
                    case "column3" -> gridRow.put("column3", leadDto.getAccountType());
                    case "column4" -> gridRow.put("column4", leadDto.getProblemStatement());
                    case "column5" -> gridRow.put("column5", leadDto.getAmountOverdue().toString());
                    case "column6" -> gridRow.put("column6", leadDto.getCreditStatus());
                    case "column7" -> gridRow.put("column7", leadDto.getCurrentBalance().toString());
                    case "column8" -> gridRow.put("column8", leadDto.getOwnership());
                    case "column9" -> gridRow.put("column9", leadDto.getSuitFiled());
                    case "column10" -> gridRow.put("column10", leadDto.getWrittenOffAmountTotal().toString());
                    case "column11" -> gridRow.put("column11", leadDto.getWrittenOffAmountPrincipal().toString());
                    case "column12" -> gridRow.put("column12", leadDto.getSanctionedAmount().toString());
                }
                componentDto.fillEmptyColumns(gridRow, 13);
            });
            gridDetails.add(gridRow);
        });
        componentDto.setGridValues(gridDetails);
    }

    public Long getPidFromRequest(HttpServletRequest request){
        CredaegisContextDto context = null;
        Long pid = 0L;
        String identifier = request.getParameter("identifier");
        String pidStr = request.getParameter("pid");
        String personId = "";
        if (null == pidStr || pidStr.isEmpty()){
            personId = identifier;
        } else {
            personId = pidStr;
        }
        if (null == personId || personId.isEmpty()){
            context = (CredaegisContextDto) request.getSession().getAttribute(CibilConstants.CREDAEGIS_CONTEXT);
            if (null != context) {
                pid = context.getPid();
            }
        } else {
            pid = Long.parseLong(personId);
            context = new CredaegisContextDto.CredaegisContextBuilder(pid).build();
            request.getSession().setAttribute(CibilConstants.CREDAEGIS_CONTEXT, context);
        }
        return pid;
    }

}
