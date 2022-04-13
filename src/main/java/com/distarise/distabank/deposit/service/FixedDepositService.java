package com.distarise.distabank.deposit.service;

import com.distarise.base.service.AbstractBaseService;
import com.distarise.distabank.deposit.model.FixedDepositDto;

import java.util.List;

public interface FixedDepositService extends AbstractBaseService {
    void saveFd(FixedDepositDto fixedDepositDto);
    List<FixedDepositDto> findAllByClientId(String clientId);
    List<FixedDepositDto> findAllByClientIdAndCustomerId(String clientId, Long customerId);
}
