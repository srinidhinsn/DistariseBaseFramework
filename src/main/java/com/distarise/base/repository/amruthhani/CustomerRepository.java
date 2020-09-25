package com.distarise.base.repository.amruthhani;

import com.distarise.base.entity.amruthhani.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(Long id);
}
