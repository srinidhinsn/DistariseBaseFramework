package com.distarise.distabank.deposit.dao.impl;

import com.distarise.distabank.deposit.dao.FixedDepositConfigDao;
import com.distarise.distabank.deposit.entity.FixedDepositConfig;
import com.distarise.distabank.deposit.model.FixedDepositConfigDto;
import com.distarise.distabank.deposit.repository.FixedDepositConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FixedDepositConfigDaoImpl implements FixedDepositConfigDao {

    @Autowired
    FixedDepositConfigRepository fdConfigRepository;

    @Override
    public void saveFdConfig(FixedDepositConfigDto fdConfig) {
        fdConfigRepository.save(modelMapper.map(fdConfig, FixedDepositConfig.class));
    }

    @Override
    public FixedDepositConfigDto getFdConfig(String clientId, Date effectiveDate, Date endDate) {
        FixedDepositConfig fixedDepositConfig = null;
        java.sql.Date effectDateSql = null;
        java.sql.Date endDateSql = null;
        if (null != effectiveDate) {
            effectDateSql = new java.sql.Date(effectiveDate.getTime());
        }
        if (null != endDate){
            endDateSql =  new java.sql.Date(endDate.getTime());
        }
        if (null == endDateSql){
            fixedDepositConfig = fdConfigRepository.findActive(clientId, effectDateSql);
        } else {
            fixedDepositConfig = fdConfigRepository.findByEffectiveAndEndDate(clientId, effectDateSql, endDateSql);
        }
        if (null != fixedDepositConfig) {
            return modelMapper.map(fixedDepositConfig, FixedDepositConfigDto.class);
        }else {
            return null;
        }
    }

    @Override
    public FixedDepositConfigDto getFdConfig(Long id) {
        FixedDepositConfig fixedDepositConfig = fdConfigRepository.findById(id).get();
        return modelMapper.map(fixedDepositConfig, FixedDepositConfigDto.class);
    }

    @Override
    public List<FixedDepositConfigDto> getAllByClientId(String clientId) {
        List<FixedDepositConfig> fdEntityList = fdConfigRepository.findAllByClientId(clientId);
        return convertEntityToDtoList(fdEntityList);
    }

    private List<FixedDepositConfigDto> convertEntityToDtoList(List<FixedDepositConfig> fdEntityList) {
        return fdEntityList.stream().map(fdConfig -> modelMapper.map(
                fdConfig, FixedDepositConfigDto.class)).collect(Collectors.toList());
    }
}
