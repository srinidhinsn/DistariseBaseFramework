package com.distarise.base.repository.ecommerce;

import com.distarise.base.entity.ecommerce.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(Long id);
}
