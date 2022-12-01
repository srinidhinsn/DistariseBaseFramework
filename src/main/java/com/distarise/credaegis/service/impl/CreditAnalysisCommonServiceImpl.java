package com.distarise.credaegis.service.impl;

import com.distarise.credaegis.dao.PersonDao;
import com.distarise.credaegis.model.CaseDto;
import com.distarise.credaegis.model.ContactDto;
import com.distarise.credaegis.model.EmailDto;
import com.distarise.credaegis.model.IdentityDto;
import com.distarise.credaegis.model.PersonDto;
import com.distarise.credaegis.service.CreditAnalysisCommonService;
import com.distarise.credaegis.service.CreditAnalysisHelperService;
import com.distarise.credaegis.service.CreditAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditAnalysisCommonServiceImpl implements CreditAnalysisCommonService {

    @Autowired
    private CreditAnalysisHelperService creditAnalysisHelperService;
    @Autowired
    private CreditAnalysisService creditAnalysisService;

    @Autowired
    private PersonDao personDao;
    @Override
    public void processCreditReport(String reportType, String pdf) {
        switch (reportType){
            /*case "cibil" -> {
                creditAnalysisHelperService = new CibilAnalysisHelperServiceImpl();
                creditAnalysisService = new CibilAnalysisServiceImpl();
            }*/
            default -> {
                creditAnalysisHelperService = new CibilAnalysisHelperServiceImpl();
                creditAnalysisService = new CibilAnalysisServiceImpl();
            }
        }

        String personalInfo = creditAnalysisHelperService.getPersonalInfoText(pdf);
        PersonDto personDto = creditAnalysisService.getPersonalInfo(personalInfo);
        personDto = personDao.save(personDto);

        IdentityDto pan = new IdentityDto(creditAnalysisHelperService.getPanNo(pdf),
                personDto.getPid(), "PAN");

        List<String> accountInfoList = creditAnalysisHelperService.getAccountInfoText(pdf);
        List<CaseDto> caseDtoList = creditAnalysisService.createCases(accountInfoList);
        List<CaseDto> validCaseDtoList = caseDtoList.stream().filter(caseDto ->
                !caseDto.getCreditStatus().isEmpty() ||
                caseDto.getAmountOverdue() > 0 ||
                !caseDto.getLatestPaymentDone().substring(8, caseDto.getLatestPaymentDone().length()-1).equals("STD") ||
                !caseDto.getLatestPaymentDone().substring(8, caseDto.getLatestPaymentDone().length()-1).equals("0")).
                collect(Collectors.toList());

    }

}
