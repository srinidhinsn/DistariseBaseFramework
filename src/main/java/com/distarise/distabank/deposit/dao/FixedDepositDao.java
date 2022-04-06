package com.distarise.distabank.deposit.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.distabank.deposit.model.FixedDepositDto;

import java.util.List;

public interface FixedDepositDao extends AbstractBaseDao {
    void saveFd(FixedDepositDto fixedDepositDto);
    List<FixedDepositDto> findAllByClientId(String clientId);
}
