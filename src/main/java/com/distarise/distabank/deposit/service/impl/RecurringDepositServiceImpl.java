package com.distarise.distabank.deposit.service.impl;

import com.distarise.distabank.deposit.dao.RecurringDepositConfigDao;
import com.distarise.distabank.deposit.dao.RecurringDepositDao;
import com.distarise.distabank.deposit.model.RecurringDepositConfigDto;
import com.distarise.distabank.deposit.model.RecurringDepositDto;
import com.distarise.distabank.deposit.service.RecurringDepositService;
import com.distarise.distabank.util.DepositAccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecurringDepositServiceImpl implements RecurringDepositService {

    @Autowired
    private RecurringDepositDao rdDao;

    @Autowired
    private RecurringDepositConfigDao rdConfigDao;

    @Override
    public void saveRd(RecurringDepositDto rdDto) {
        if (null == rdDto.getId() || rdDto.getId().equals(0)) {
            RecurringDepositConfigDto rdConfigDto = rdConfigDao.getRdConfig(rdDto.getClientId(),
                    rdDto.getEffectiveDate(), rdDto.getMaturityDate());
            if (rdConfigDto.getRoi().equals(rdDto.getRoi())) {
                rdDto.setStatus(DepositAccountStatus.Active.name());
            } else {
                rdDto.setStatus(DepositAccountStatus.Pending.name());
            }
        }
        rdDao.saveRd(rdDto);
    }

    @Override
    public List<RecurringDepositDto> findAllByClientId(String clientId) {
        return rdDao.findAllByClientId(clientId);
    }

    @Override
    public List<RecurringDepositDto> findAllByClientIdAndCustomerId(String clientId, Long customerId) {
        if (null == customerId || 0L == customerId){
            return new ArrayList<>();
        }
        return rdDao.findAllByClientIdAndCustomerId(clientId, customerId);
    }

    @Override
    public RecurringDepositDto findById(String selectedRd) {
        return rdDao.findById(selectedRd);
    }
}
