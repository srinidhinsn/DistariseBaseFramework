package com.distarise.distabank.deposit.repository;

import com.distarise.distabank.deposit.entity.FixedDeposit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixedDepositRepository extends CrudRepository<FixedDeposit, Long> {
    List<FixedDeposit> findAllByClientId(String clientId);
}
