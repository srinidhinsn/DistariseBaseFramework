package com.distarise.distabank.deposit.repository;

import com.distarise.distabank.deposit.entity.FixedDepositConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FixedDepositConfigRepository extends CrudRepository<FixedDepositConfig, Long> {
    @Query("from FixedDepositConfig where clientId =:clientId and effectiveDate <=:effectiveDate " +
            " and endDate is null ")
    FixedDepositConfig findActive(@Param("clientId") String clientId,
                                  @Param("effectiveDate") Date effectDateSql);

    @Query("from FixedDepositConfig where clientId =:clientId and effectiveDate <=:effectiveDate " +
            " and (endDate is null or endDate >=:endDate)")
    FixedDepositConfig findByEffectiveAndEndDate(@Param("clientId") String clientId,
                                                 @Param("effectiveDate") Date effectDateSql,
                                                 @Param("endDate") Date endDateSql);


    @Query("from FixedDepositConfig where clientId =?1")
    List<FixedDepositConfig> findAllByClientId(String clientId);
}
