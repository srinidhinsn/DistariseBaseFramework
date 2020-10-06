package com.distarise.base.service.ecommerce;

import com.distarise.base.model.ecommerce.OrdersDto;
import com.distarise.base.service.AbstractBaseService;

public interface OrdersService extends AbstractBaseService {
    OrdersDto save(OrdersDto order);
    OrdersDto findById(Long id);
}
