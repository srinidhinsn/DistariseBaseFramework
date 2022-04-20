package com.distarise.distabank.deposit.service;

import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.service.AbstractBaseService;
import com.distarise.distabank.deposit.model.RecurringDepositConfigDto;

import java.util.Date;
import java.util.List;

public interface RecurringDepositConfigService extends AbstractBaseService {
    void saveRdConfig(RecurringDepositConfigDto rdConfig);
    RecurringDepositConfigDto getRdConfig(String clientId, Date effectiveDate, Date endDate);
    RecurringDepositConfigDto getRdConfig(Long id);
    List<RecurringDepositConfigDto> getAllByClientId(String clientId);
    boolean validateRdConfig(RecurringDepositConfigDto rdConfig, PageDetailsDto pageDto);
}
