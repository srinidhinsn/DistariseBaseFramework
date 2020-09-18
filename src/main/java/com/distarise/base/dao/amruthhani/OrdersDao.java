package com.distarise.base.dao.amruthhani;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.model.amruthhani.OrdersDto;
import com.distarise.base.model.amruthhani.ProductDto;

import java.util.List;

public interface OrdersDao extends AbstractBaseDao {
    OrdersDto save(OrdersDto ordersDto);
}
