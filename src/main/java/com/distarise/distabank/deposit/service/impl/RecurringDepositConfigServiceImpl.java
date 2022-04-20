package com.distarise.distabank.deposit.service.impl;

import com.distarise.base.model.PageDetailsDto;
import com.distarise.distabank.deposit.dao.RecurringDepositConfigDao;
import com.distarise.distabank.deposit.model.FixedDepositConfigDto;
import com.distarise.distabank.deposit.model.RecurringDepositConfigDto;
import com.distarise.distabank.deposit.service.RecurringDepositConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecurringDepositConfigServiceImpl implements RecurringDepositConfigService {

    @Autowired
    private RecurringDepositConfigDao rdConfigDao;

    @Override
    public void saveRdConfig(RecurringDepositConfigDto rdConfig) {
        rdConfigDao.saveRdConfig(rdConfig);
    }

    @Override
    public RecurringDepositConfigDto getRdConfig(String clientId, Date effectiveDate, Date endDate) {
        return rdConfigDao.getRdConfig(clientId, effectiveDate, endDate);
    }

    @Override
    public RecurringDepositConfigDto getRdConfig(Long id) {
        if (null == id){
            return  null;
        }
        return rdConfigDao.getRdConfig(id);
    }

    @Override
    public List<RecurringDepositConfigDto> getAllByClientId(String clientId) {
        return rdConfigDao.getAllByClientId(clientId);
    }

    @Override
    public boolean validateRdConfig(RecurringDepositConfigDto rdConfig, PageDetailsDto pageDto) {
        Boolean valid = true;
        if (rdConfig.getRoi().equals(0)){
            pageDto.getErrorMessages().add("Rate of interest cannot be zero");
        }
        if (null == rdConfig.getEffectiveDate()){
            pageDto.getErrorMessages().add("Effective date cannot be empty");
        }
        if (null == rdConfig.getEndDate()){
            pageDto.getErrorMessages().add("Effective till date cannot be empty");
        }
        if (pageDto.getErrorMessages().size() == 0){
            RecurringDepositConfigDto rdDto = rdConfigDao.getRdConfig(rdConfig.getClientId(), rdConfig.getEffectiveDate(), rdConfig.getEndDate());
            if (null != rdDto){
                pageDto.getErrorMessages().add("Active RD config already exists");
            }
        }
        if (pageDto.getErrorMessages().size() > 0){
            valid = false;
        }
        return valid;
    }

}
