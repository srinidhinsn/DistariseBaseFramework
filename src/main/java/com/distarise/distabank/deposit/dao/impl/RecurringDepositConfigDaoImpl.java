package com.distarise.distabank.deposit.dao.impl;

import com.distarise.distabank.deposit.dao.RecurringDepositConfigDao;
import com.distarise.distabank.deposit.entity.RecurringDepositConfig;
import com.distarise.distabank.deposit.model.RecurringDepositConfigDto;
import com.distarise.distabank.deposit.repository.RecurringDepositConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecurringDepositConfigDaoImpl implements RecurringDepositConfigDao {

    @Autowired
    RecurringDepositConfigRepository rdConfigRepository;

    @Override
    public void saveRdConfig(RecurringDepositConfigDto rdConfig) {
        rdConfigRepository.save(modelMapper.map(rdConfig, RecurringDepositConfig.class));
    }

    @Override
    public RecurringDepositConfigDto getRdConfig(String clientId, Date effectiveDate, Date endDate) {
        RecurringDepositConfig rdConfig = null;
        java.sql.Date effectDateSql = null;
        java.sql.Date endDateSql = null;
        if (null != effectiveDate) {
            effectDateSql = new java.sql.Date(effectiveDate.getTime());
        }
        if (null != endDate){
            endDateSql =  new java.sql.Date(endDate.getTime());
        }
        if (null == endDateSql){
            rdConfig = rdConfigRepository.findActive(clientId, effectDateSql);
        } else {
            rdConfig = rdConfigRepository.findByEffectiveAndEndDate(clientId, effectDateSql, endDateSql);
        }
        if (null != rdConfig) {
            return modelMapper.map(rdConfig, RecurringDepositConfigDto.class);
        }else {
            return null;
        }
    }

    @Override
    public RecurringDepositConfigDto getRdConfig(Long id) {
        RecurringDepositConfig fixedDepositConfig = rdConfigRepository.findOne(id);
        return modelMapper.map(fixedDepositConfig, RecurringDepositConfigDto.class);
    }

    @Override
    public List<RecurringDepositConfigDto> getAllByClientId(String clientId) {
        List<RecurringDepositConfig> rdEntityList = rdConfigRepository.findAllByClientId(clientId);
        return convertEntityToDtoList(rdEntityList);
    }

    private List<RecurringDepositConfigDto> convertEntityToDtoList(List<RecurringDepositConfig> fdEntityList) {
        return fdEntityList.stream().map(fdConfig -> modelMapper.map(
                fdConfig, RecurringDepositConfigDto.class)).collect(Collectors.toList());
    }
}
