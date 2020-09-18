package com.distarise.base.service.amruthhani;

import com.distarise.base.model.amruthhani.OrdersDto;
import com.distarise.base.service.AbstractBaseService;

public interface OrdersService extends AbstractBaseService {
    OrdersDto save(OrdersDto order);
}
