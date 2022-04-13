package com.distarise.distabank.deposit.service.impl;

import com.distarise.distabank.deposit.dao.FixedDepositConfigDao;
import com.distarise.distabank.deposit.dao.FixedDepositDao;
import com.distarise.distabank.deposit.model.FixedDepositConfigDto;
import com.distarise.distabank.deposit.model.FixedDepositDto;
import com.distarise.distabank.deposit.service.FixedDepositConfigService;
import com.distarise.distabank.deposit.service.FixedDepositService;
import com.distarise.distabank.util.DepositAccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    private FixedDepositDao fixedDepositDao;

    @Autowired
    private FixedDepositConfigDao fdConfigDao;

    @Override
    public void saveFd(FixedDepositDto fixedDepositDto) {
        FixedDepositConfigDto fdConfigDto = fdConfigDao.getFdConfig(fixedDepositDto.getClientId(),
                fixedDepositDto.getEffectiveDate(), fixedDepositDto.getMaturityDate());
        if (fdConfigDto.getRoi().equals(fixedDepositDto.getRoi())){
            fixedDepositDto.setStatus(DepositAccountStatus.Active.name());
        } else {
            fixedDepositDto.setStatus(DepositAccountStatus.Pending.name());
        }
        fixedDepositDao.saveFd(fixedDepositDto);
    }

    @Override
    public List<FixedDepositDto> findAllByClientId(String clientId) {
        return fixedDepositDao.findAllByClientId(clientId);
    }

    @Override
    public List<FixedDepositDto> findAllByClientIdAndCustomerId(String clientId, Long customerId) {
        if (null == customerId || 0L == customerId){
            return new ArrayList<>();
        }
        return fixedDepositDao.findAllByClientIdAndCustomerId(clientId, customerId);
    }
}
