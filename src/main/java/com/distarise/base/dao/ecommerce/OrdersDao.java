package com.distarise.base.dao.ecommerce;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.model.ecommerce.OrdersDto;

public interface OrdersDao extends AbstractBaseDao {
    OrdersDto save(OrdersDto ordersDto);
    OrdersDto findById(Long id);
}
