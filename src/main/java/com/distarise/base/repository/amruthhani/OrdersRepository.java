package com.distarise.base.repository.amruthhani;

import com.distarise.base.entity.amruthhani.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, String> {
    Orders save(Orders orders);
    Orders findById(Long id);
}
