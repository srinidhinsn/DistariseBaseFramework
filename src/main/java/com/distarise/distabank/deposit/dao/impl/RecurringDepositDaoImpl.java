package com.distarise.distabank.deposit.dao.impl;

import com.distarise.distabank.deposit.dao.RecurringDepositDao;
import com.distarise.distabank.deposit.entity.RecurringDeposit;
import com.distarise.distabank.deposit.model.RecurringDepositDto;
import com.distarise.distabank.deposit.repository.RecurringDepositConfigRepository;
import com.distarise.distabank.deposit.repository.RecurringDepositRepository;
import com.distarise.distabank.util.AccountType;
import com.distarise.distabank.util.DistabankUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecurringDepositDaoImpl implements RecurringDepositDao {

    @Autowired
    RecurringDepositRepository rdRepository;

    @Autowired
    RecurringDepositConfigRepository rdConfigRepository;

    @Override
    public void saveRd(RecurringDepositDto rdDto) {
        RecurringDeposit rd = rdRepository.save(modelMapper.map(rdDto, RecurringDeposit.class));
        rd.setAccountNo(DistabankUtils.padAccountNo(rd.getClientId(), AccountType.RD.name(), rd.getId().toString()));
        rdRepository.save(rd);
    }

    @Override
    public List<RecurringDepositDto> findAllByClientId(String clientId) {
        return convertEntityToDtoList(rdRepository.findAllByClientId(clientId));
    }

    private List<RecurringDepositDto> convertEntityToDtoList(List<RecurringDeposit> allByClientId) {
        return allByClientId.stream().map(fd -> modelMapper.map(
                fd, RecurringDepositDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RecurringDepositDto> findAllByClientIdAndCustomerId(String clientId, Long customerId){
        return convertEntityToDtoList(rdRepository.findAllByClientIdAndCustomerId(clientId, customerId));
    }

    @Override
    public RecurringDepositDto findById(String selectedRd) {
        return convertEntityToDto(rdRepository.findById(Long.parseLong(selectedRd)).get());
    }

    private RecurringDepositDto convertEntityToDto(RecurringDeposit one) {
        return modelMapper.map(one, RecurringDepositDto.class);
    }
}
