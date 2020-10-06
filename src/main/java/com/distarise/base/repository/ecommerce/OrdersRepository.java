package com.distarise.base.repository.ecommerce;

import com.distarise.base.entity.ecommerce.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, String> {
    Orders save(Orders orders);
    Orders findById(Long id);
}
