package com.distarise.credaegis.service;

import java.util.List;

public interface CreditAnalysisHelperService {
    String getPersonalInfoText(String pdf);

    String getPanNo(String pdf);
    List<String> getAccountInfoText(String pdf);
}
