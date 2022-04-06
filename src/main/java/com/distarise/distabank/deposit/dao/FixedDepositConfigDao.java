package com.distarise.distabank.deposit.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.distabank.deposit.model.FixedDepositConfigDto;

import java.util.Date;
import java.util.List;

public interface FixedDepositConfigDao extends AbstractBaseDao {
    void saveFdConfig(FixedDepositConfigDto fdConfig);
    FixedDepositConfigDto getFdConfig(String clientId, Date effectiveDate, Date endDate);
    FixedDepositConfigDto getFdConfig(Long id);
    List<FixedDepositConfigDto> getAllByClientId(String clientId);
}
