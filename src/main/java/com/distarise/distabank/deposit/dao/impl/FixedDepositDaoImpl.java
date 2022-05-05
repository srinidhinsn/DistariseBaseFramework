package com.distarise.distabank.deposit.dao.impl;

import com.distarise.distabank.deposit.dao.FixedDepositDao;
import com.distarise.distabank.deposit.entity.FixedDeposit;
import com.distarise.distabank.deposit.model.FixedDepositDto;
import com.distarise.distabank.deposit.repository.FixedDepositConfigRepository;
import com.distarise.distabank.deposit.repository.FixedDepositRepository;
import com.distarise.distabank.util.AccountType;
import com.distarise.distabank.util.DistabankUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        if (null == fixedDepositDto.getId() || 0 == fixedDepositDto.getId()){
            fd.setAccountNo(DistabankUtils.padAccountNo(fd.getClientId(), AccountType.FD.name(), fd.getId().toString()));
            fdRepository.save(fd);
        }
    }

    @Override
    public List<FixedDepositDto> findAllByClientId(String clientId) {
        return convertEntityToDtoList(fdRepository.findAllByClientId(clientId));
    }

    private List<FixedDepositDto> convertEntityToDtoList(List<FixedDeposit> allByClientId) {
        return allByClientId.stream().map(fd -> modelMapper.map(
                fd, FixedDepositDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<FixedDepositDto> findAllByClientIdAndCustomerId(String clientId, Long customerId){
        return convertEntityToDtoList(fdRepository.findAllByClientIdAndCustomerId(clientId, customerId));
    }

    @Override
    public FixedDepositDto findById(String selectedFd) {
        return convertEntityToDto(fdRepository.findById(Long.parseLong(selectedFd)).get());
    }

    private FixedDepositDto convertEntityToDto(FixedDeposit one) {
        return modelMapper.map(one, FixedDepositDto.class);
    }
}