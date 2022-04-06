package com.distarise.distabank.customer.repository;

import com.distarise.distabank.customer.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query("from Customer where clientId = ?1 and lower(firstname) like %?2% or lower(lastname) like %?2% or " +
            " phone like %?2% order by firstname asc")
    List<Customer> findAllBySearchKey(String clientId, String searchKey);
    List<Customer> findAllByClientId(String clientId);
}
