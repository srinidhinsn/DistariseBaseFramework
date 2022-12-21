package com.distarise.credaegis.service.impl;

import com.distarise.credaegis.constants.CibilConstants;
import com.distarise.credaegis.service.CreditAnalysisHelperService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String panNumber = CibilUtility.getStringBetween(pdf.replaceAll("\\s+", ""),
                CibilConstants.PERSON_PAN.replaceAll("\\s+", ""),
                CibilConstants.PERSON_BREAK);
        return panNumber;
    }

    @Override
    public String getContact(String pdf) {
        Pattern phoneNumber = Pattern.compile("([0-9]{10})");
        Matcher match = phoneNumber.matcher(pdf);
        if(match.find()){
            return match.group();
        }
        return "9000000000";
    }

    @Override
    public List<String> getAccountInfoText(String pdf) {
        String croppedPdf = CibilUtility.getStringBetween(pdf, CibilConstants.ACCOUNT_START,
                CibilConstants.ACCOUNT_END);
        return Arrays.asList(croppedPdf.split(CibilConstants.ACCOUNT_BREAK));
    }


}
