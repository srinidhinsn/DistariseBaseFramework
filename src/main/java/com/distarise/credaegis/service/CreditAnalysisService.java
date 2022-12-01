package com.distarise.credaegis.service;

import com.distarise.credaegis.model.AddressDto;
import com.distarise.credaegis.model.CaseDto;
import com.distarise.credaegis.model.ContactDto;
import com.distarise.credaegis.model.EmailDto;
import com.distarise.credaegis.model.IdentityDto;
import com.distarise.credaegis.model.PersonDto;

import java.util.List;

public interface CreditAnalysisService {
    PersonDto getPersonalInfo(String pdfDoc);
    List<CaseDto> createCases(List<String> accountsInfoList);
}
