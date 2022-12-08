package com.distarise.credaegis.service;

import com.distarise.credaegis.model.PersonDto;

import javax.servlet.http.HttpServletRequest;

public interface CreditAnalysisCommonService {
    void processCreditReport(HttpServletRequest request, PersonDto personDto, String pdf);
}
