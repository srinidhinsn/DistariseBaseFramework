package com.distarise.credaegis.service.impl;

import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.service.CreditAnalysisHelperService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CibilAnalysisHelperServiceImpl implements CreditAnalysisHelperService {

    @Override
    public String getPersonalInfoText(String pdf) {
        String personInfo = CibilUtility.getStringBetween(pdf, CibilConstants.PERSON_START,
                CibilConstants.PERSON_ID_START);
        return personInfo;
    }

    @Override
    public String getPanNo(String pdf) {
        String panNumber = CibilUtility.getStringBetween(pdf, CibilConstants.PERSON_PAN,
                CibilConstants.PERSON_BREAK);
        return panNumber;
    }

    @Override
    public List<String> getAccountInfoText(String pdf) {
        String croppedPdf = CibilUtility.getStringBetween(pdf, CibilConstants.ACCOUNT_START,
                CibilConstants.ACCOUNT_END);
        return Arrays.asList(croppedPdf.split(CibilConstants.ACCOUNT_BREAK));
    }


}
