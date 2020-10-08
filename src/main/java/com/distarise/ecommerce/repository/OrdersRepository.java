package com.distarise.ecommerce.repository;

import com.distarise.ecommerce.entity.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, String> {
    Orders save(Orders orders);
    Orders findById(Long id);
}
