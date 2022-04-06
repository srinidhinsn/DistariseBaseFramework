package com.distarise.distabank.deposit.service.impl;

import com.distarise.distabank.deposit.dao.FixedDepositDao;
import com.distarise.distabank.deposit.model.FixedDepositDto;
import com.distarise.distabank.deposit.service.FixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    private FixedDepositDao fixedDepositDao;

    @Override
    public void saveFd(FixedDepositDto fixedDepositDto) {
        fixedDepositDao.saveFd(fixedDepositDto);
    }

    @Override
    public List<FixedDepositDto> findAllByClientId(String clientId) {
        return fixedDepositDao.findAllByClientId(clientId);
    }
}
