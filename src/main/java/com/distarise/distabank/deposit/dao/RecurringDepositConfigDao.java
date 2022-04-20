package com.distarise.distabank.deposit.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.distabank.deposit.model.RecurringDepositConfigDto;

import java.util.Date;
import java.util.List;

public interface RecurringDepositConfigDao extends AbstractBaseDao {
    void saveRdConfig(RecurringDepositConfigDto rdConfig);
    RecurringDepositConfigDto getRdConfig(String clientId, Date effectiveDate, Date endDate);
    RecurringDepositConfigDto getRdConfig(Long id);
    List<RecurringDepositConfigDto> getAllByClientId(String clientId);
}
