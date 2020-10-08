package com.distarise.ecommerce.service;

import com.distarise.ecommerce.model.OrdersDto;
import com.distarise.base.service.AbstractBaseService;

public interface OrdersService extends AbstractBaseService {
    OrdersDto save(OrdersDto order);
    OrdersDto findById(Long id);
}
