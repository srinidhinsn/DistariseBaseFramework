package com.distarise.credaegis.action;

import com.distarise.base.action.AbstractBaseAction;
import com.distarise.base.action.BaseAction;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.dao.LeadDao;
import com.distarise.credaegis.dao.PersonDao;
import com.distarise.credaegis.model.CredaegisContextDto;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EditOrDeleteAccountAction extends AbstractBaseAction implements BaseAction {
    @Autowired
    private LeadDao leadDao;

    @Autowired
    private LoadAnalysisReportAction loadAnalysisReportAction;

    @Override
    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        String identifier = request.getParameter("identifier");
        String[] leadIdAndAction = identifier.split("-");
        Long leadId = Long.parseLong(leadIdAndAction[0]);

        if (leadIdAndAction[1].equalsIgnoreCase("delete")){
            leadDao.delete(leadId);
            loadAnalysisReportAction.executeAction(request);
            loadAnalysisReportAction.executeAction();
        } else if (leadIdAndAction[1].equalsIgnoreCase("edit")){
            LeadDto leadDto = leadDao.getLeadById(leadId);
            targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach( navigationItemDto -> {
                navigationItemDto.getWidgets().forEach(widgetDto ->  {
                    if (widgetDto.getId().equalsIgnoreCase("editlead")){
                        widgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            setAccountDetails(targetComponentDto, leadDto, request);
                        });
                    }
                });
            });
        }
    }

    private void setAccountDetails(ComponentDto componentDto, LeadDto leadDto, HttpServletRequest request){
        CredaegisContextDto context = (CredaegisContextDto) request.getSession().getAttribute(CibilConstants.CREDAEGIS_CONTEXT);
        switch (componentDto.getId()){
            case "pid" -> componentDto.setValue(context.getPid().toString());
            case "leadid" -> componentDto.setValue(leadDto.getLid().toString());
            case "accountName" -> componentDto.setValue(leadDto.getAccountName());
            case "accountNo" -> componentDto.setValue(leadDto.getAccountNo());
            case "accountType" -> componentDto.setValue(leadDto.getAccountType());
            case "ownership" -> componentDto.setValue(leadDto.getOwnership());
            case "sanctionedAmount" -> componentDto.setValue(leadDto.getSanctionedAmount().toString());
            case "currentBalance" -> componentDto.setValue(leadDto.getCurrentBalance().toString());
            case "amountOverdue" -> componentDto.setValue(leadDto.getAmountOverdue().toString());
            case "dateReported" -> componentDto.setValue(leadDto.getDateReported().toString());
            case "creditStatus" -> componentDto.setValue(leadDto.getCreditStatus());
            case "writtenOffAmountTotal" -> componentDto.setValue(leadDto.getWrittenOffAmountTotal().toString());
            case "writtenOffAmountPrincipal" -> componentDto.setValue(leadDto.getWrittenOffAmountPrincipal().toString());
            case "suitFiled" -> componentDto.setValue(leadDto.getSuitFiled());
            case "settlementAmount" -> componentDto.setValue(leadDto.getSettlementAmount().toString());
            case "lastPaymentDone" -> componentDto.setValue(leadDto.getLatestPaymentDone());
            case "recentDpd" -> componentDto.setValue(leadDto.getProblemStatement());
        }

    }


}
