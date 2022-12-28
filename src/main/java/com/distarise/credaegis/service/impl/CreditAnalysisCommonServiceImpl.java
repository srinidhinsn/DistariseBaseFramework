package com.distarise.credaegis.service.impl;

import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.constants.WorkLogConstants;
import com.distarise.credaegis.dao.IdentityDao;
import com.distarise.credaegis.dao.LeadDao;
import com.distarise.credaegis.dao.PersonDao;
import com.distarise.credaegis.dao.WorkDao;
import com.distarise.credaegis.enumerations.LeadStatus;
import com.distarise.credaegis.model.IdentityDto;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;
import com.distarise.credaegis.model.WorkDto;
import com.distarise.credaegis.service.CreditAnalysisCommonService;
import com.distarise.credaegis.service.CreditAnalysisHelperService;
import com.distarise.credaegis.service.CreditAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditAnalysisCommonServiceImpl implements CreditAnalysisCommonService {

    @Autowired
    private CreditAnalysisHelperService creditAnalysisHelperService;
    @Autowired
    private CreditAnalysisService creditAnalysisService;

    @Autowired
    private LeadDao leadDao;

    @Autowired
    private IdentityDao identityDao;
    @Autowired
    private PersonDao personDao;

    @Autowired
    private WorkDao workDao;
    @Override
    public void processCreditReport(HttpServletRequest request, PersonDto personDto, String pdf) {
        switch (personDto.getReportType()){
            /*case "cibil" -> {
                creditAnalysisHelperService = new CibilAnalysisHelperServiceImpl();
                creditAnalysisService = new CibilAnalysisServiceImpl();
            }*/
            default -> {
                creditAnalysisHelperService = new CibilAnalysisHelperServiceImpl();
                creditAnalysisService = new CibilAnalysisServiceImpl();
            }
        }
        pdf = pdf.replaceAll("\f","");
        pdf = pdf.replaceAll("\n","");
        String personalInfo = creditAnalysisHelperService.getPersonalInfoText(pdf);
        creditAnalysisService.setPersonalInfo(personalInfo, personDto);
        creditAnalysisService.setCreditScore(pdf, personDto);
        personDto.setContact(creditAnalysisHelperService.getContact(pdf));
        personDto = personDao.save(personDto);
        IdentityDto pan = new IdentityDto(creditAnalysisHelperService.getPanNo(pdf),
                personDto.getPid(), "PAN");
        pan = identityDao.save(pan);

        List<String> accountInfoList = creditAnalysisHelperService.getAccountInfoText(pdf);
        List<LeadDto> leadDtoList = creditAnalysisService.createLeads(accountInfoList);
        List<LeadDto> validLeadDtoList = leadDtoList.stream().filter(leadDto ->
                !leadDto.getCreditStatus().isEmpty() ||
                        (!leadDto.getSanctionedAmount().equals(0L) &&
                                leadDto.getCurrentBalance() > leadDto.getSanctionedAmount()) ||
                leadDto.getAmountOverdue() > 0 ||
                        !leadDto.getProblemStatement().isEmpty()).
                collect(Collectors.toList());

        setLeadDetails(validLeadDtoList, personDto);
        personDto.setLeadDtoList(validLeadDtoList);
        leadDao.save(validLeadDtoList);

        WorkDto workDto = createWork(personDto);
        workDao.save(workDto);


        /*
        CredaegisContextDto credaegisContextDto = new CredaegisContextDto.
                CredaegisContextBuilder(personDto.getPid()).
                personDto(personDto).build();
        request.getSession().setAttribute(CibilConstants.CREDAEGIS_CONTEXT, credaegisContextDto);*/
    }

    private WorkDto createWork(PersonDto personDto) {
        WorkDto workDto = new WorkDto();
        workDto.setPid(personDto.getPid());
        workDto.setLid(-1L);
        workDto.setEid(-1L);
        workDto.setTitle(personDto.getFirstName());
        workDto.setComment(WorkLogConstants.WORK_ENTRY);
        workDto.setStatus(LeadStatus.OPEN.name());
        workDto.setReviewDate(new Date());
        workDto.setLastUpdated(new Date());
        return workDto;
    }

    private void setLeadDetails(List<LeadDto> validLeadDtoList, PersonDto personDto) {
        for (LeadDto leadDto : validLeadDtoList){
            //String dpds = leadDto.getLatestPaymentDone().substring(8, leadDto.getLatestPaymentDone().length());
            /*
            if (!leadDto.getCreditStatus().isEmpty()){
                leadDto.setProblemStatement(leadDto.getCreditStatus());
            } if (leadDto.getAmountOverdue() > 0){
                leadDto.setProblemStatement(CibilConstants.PS_AMOUNT_OVERDUE+leadDto.getAmountOverdue());
            } if (!leadDto.getLatestPaymentDone().isEmpty()) {
                leadDto.setProblemStatement(CibilConstants.PS_DPD + leadDto.getLatestPaymentDone());
            }
            */
            //leadDto.setLatestPaymentDone(leadDto.getLatestPaymentDone().substring(0, 8) + " " + dpds);
            leadDto.setPid(personDto.getPid());
            leadDto.setTitle(personDto.getFirstName() + "-" + leadDto.getAccountNo() + "-" + leadDto.getProblemStatement());
            leadDto.setStatus(LeadStatus.OPEN.name());
        }
    }
}
