package com.distarise.distabank.deposit.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.distabank.deposit.model.RecurringDepositDto;

import java.util.List;

public interface RecurringDepositDao extends AbstractBaseDao {
    void saveRd(RecurringDepositDto rdDto);
    List<RecurringDepositDto> findAllByClientId(String clientId);
    List<RecurringDepositDto> findAllByClientIdAndCustomerId(String clientId, Long customerId);
    RecurringDepositDto findById(String selectedRd);
}
