package com.distarise.credaegis.service;

import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.PersonDto;

import java.util.List;

public interface CreditAnalysisService {
    PersonDto setPersonalInfo(String pdfDoc, PersonDto personDto);
    List<LeadDto> createLeads(List<String> accountsInfoList);
    void setCreditScore(String pdf, PersonDto personDto);
}
