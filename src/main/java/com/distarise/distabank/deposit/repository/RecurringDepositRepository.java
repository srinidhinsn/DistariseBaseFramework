package com.distarise.distabank.deposit.repository;

import com.distarise.distabank.deposit.entity.RecurringDeposit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecurringDepositRepository extends CrudRepository<RecurringDeposit, Long> {
    List<RecurringDeposit> findAllByClientId(String clientId);
    List<RecurringDeposit> findAllByClientIdAndCustomerId(String clientId, Long customerId);
}
