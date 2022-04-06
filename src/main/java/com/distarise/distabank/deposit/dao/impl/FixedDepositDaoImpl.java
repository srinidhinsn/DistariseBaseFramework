package com.distarise.distabank.deposit.dao.impl;

import com.distarise.distabank.deposit.dao.FixedDepositDao;
import com.distarise.distabank.deposit.entity.FixedDeposit;
import com.distarise.distabank.deposit.entity.FixedDepositConfig;
import com.distarise.distabank.deposit.model.FixedDepositDto;
import com.distarise.distabank.deposit.repository.FixedDepositConfigRepository;
import com.distarise.distabank.deposit.repository.FixedDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FixedDepositDaoImpl implements FixedDepositDao {

    @Autowired
    FixedDepositRepository fdRepository;

    @Autowired
    FixedDepositConfigRepository fdConfigRepository;

    @Override
    public void saveFd(FixedDepositDto fixedDepositDto) {
        FixedDeposit fd = fdRepository.save(modelMapper.map(fixedDepositDto, FixedDeposit.class));
        FixedDepositConfig fdConfig = fdConfigRepository.findActive(fixedDepositDto.getClientId(),
                new Date(fixedDepositDto.getEffectiveDate().getTime()));
        fd.setAccountNo(fdConfig.getAccountNoSeq()+fd.getId());
        fdRepository.save(fd);
    }

    @Override
    public List<FixedDepositDto> findAllByClientId(String clientId) {
        return convertEntityToDtoList(fdRepository.findAllByClientId(clientId));
    }

    private List<FixedDepositDto> convertEntityToDtoList(List<FixedDeposit> allByClientId) {
        return allByClientId.stream().map(fd -> modelMapper.map(
                fd, FixedDepositDto.class)).collect(Collectors.toList());
    }

}
