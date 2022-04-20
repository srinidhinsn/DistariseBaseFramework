package com.distarise.distabank.deposit.service;

import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.service.AbstractBaseService;
import com.distarise.distabank.deposit.model.FixedDepositConfigDto;

import java.util.Date;
import java.util.List;

public interface FixedDepositConfigService extends AbstractBaseService {
    void saveFdConfig(FixedDepositConfigDto fdConfig);
    FixedDepositConfigDto getFdConfig(String clientId, Date effectiveDate, Date endDate);
    FixedDepositConfigDto getFdConfig(Long id);
    List<FixedDepositConfigDto> getAllByClientId(String clientId);
    Boolean validateFdConfig(FixedDepositConfigDto fdConfig, PageDetailsDto pageDto);
}
