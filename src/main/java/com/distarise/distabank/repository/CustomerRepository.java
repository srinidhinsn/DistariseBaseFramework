package com.distarise.distabank.repository;

import com.distarise.distabank.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query("from Customer where lower(firstname) like %?1% or lower(lastname) like %?1% or " +
            " phone like %?1% order by firstname asc")
    List<Customer> findAllBySearchKey(String searchKey);
}
