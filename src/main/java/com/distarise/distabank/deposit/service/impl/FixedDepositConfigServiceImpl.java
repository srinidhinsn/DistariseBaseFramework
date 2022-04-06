package com.distarise.distabank.deposit.service.impl;

import com.distarise.distabank.deposit.dao.FixedDepositConfigDao;
import com.distarise.distabank.deposit.model.FixedDepositConfigDto;
import com.distarise.distabank.deposit.service.FixedDepositConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FixedDepositConfigServiceImpl implements FixedDepositConfigService {

    @Autowired
    private FixedDepositConfigDao fixedDepositConfigDao;

    @Override
    public void saveFdConfig(FixedDepositConfigDto fdConfig) {
        fixedDepositConfigDao.saveFdConfig(fdConfig);
    }

    @Override
    public FixedDepositConfigDto getFdConfig(String clientId, Date effectiveDate, Date endDate) {
        return fixedDepositConfigDao.getFdConfig(clientId, effectiveDate, endDate);
    }

    @Override
    public FixedDepositConfigDto getFdConfig(Long id) {
        if (null == id){
            return  null;
        }
        return fixedDepositConfigDao.getFdConfig(id);
    }

    @Override
    public List<FixedDepositConfigDto> getAllByClientId(String clientId) {
        return fixedDepositConfigDao.getAllByClientId(clientId);
    }
}
