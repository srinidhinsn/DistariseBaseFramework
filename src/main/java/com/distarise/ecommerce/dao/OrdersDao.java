package com.distarise.ecommerce.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.ecommerce.model.OrdersDto;

public interface OrdersDao extends AbstractBaseDao {
    OrdersDto save(OrdersDto ordersDto);
    OrdersDto findById(Long id);
}
