package com.distarise.distabank.deposit.repository;

import com.distarise.distabank.deposit.entity.RecurringDepositConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RecurringDepositConfigRepository extends CrudRepository<RecurringDepositConfig, Long> {
    @Query("from RecurringDepositConfig where clientId =:clientId and effectiveDate <=:effectiveDate " +
            " and endDate is null ")
    RecurringDepositConfig findActive(@Param("clientId") String clientId,
                                  @Param("effectiveDate") Date effectDateSql);

    @Query("from RecurringDepositConfig where clientId =:clientId and ((:effectiveDate between effectiveDate and endDate) " +
            " or (:endDate between effectiveDate and endDate ))")
    RecurringDepositConfig findByEffectiveAndEndDate(@Param("clientId") String clientId,
                                                 @Param("effectiveDate") Date effectDateSql,
                                                 @Param("endDate") Date endDateSql);


    @Query("from RecurringDepositConfig where clientId =?1")
    List<RecurringDepositConfig> findAllByClientId(String clientId);
}
