package com.distarise.distabank.deposit.service;

import com.distarise.base.service.AbstractBaseService;
import com.distarise.distabank.deposit.model.RecurringDepositDto;

import java.util.List;

public interface RecurringDepositService extends AbstractBaseService {
    void saveRd(RecurringDepositDto rdDto);
    List<RecurringDepositDto> findAllByClientId(String clientId);
    List<RecurringDepositDto> findAllByClientIdAndCustomerId(String clientId, Long customerId);
    RecurringDepositDto findById(String selectedRd);
}
