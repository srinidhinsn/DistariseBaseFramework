package com.distarise.distabank.deposit.service.impl;

import com.distarise.base.model.PageDetailsDto;
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

    @Override
    public Boolean validateFdConfig(FixedDepositConfigDto fdConfig, PageDetailsDto pageDto) {
        Boolean valid = true;
        if (fdConfig.getRoi().equals(0)){
            pageDto.getErrorMessages().add("Rate of interest cannot be zero");
        }
        if (null == fdConfig.getEffectiveDate()){
            pageDto.getErrorMessages().add("Effective from date cannot be empty");
        }
        if (null == fdConfig.getEndDate()){
            pageDto.getErrorMessages().add("Effective till date cannot be empty");
        }
        if (pageDto.getErrorMessages().size() == 0){
            FixedDepositConfigDto fdDto = fixedDepositConfigDao.getFdConfig(fdConfig.getClientId(), fdConfig.getEffectiveDate(), fdConfig.getEndDate());
            if (null != fdDto){
                pageDto.getErrorMessages().add("Active FD config already exists");
            }
        }
        if (pageDto.getErrorMessages().size() > 0){
            valid = false;
        }
        return valid;
    }
}
