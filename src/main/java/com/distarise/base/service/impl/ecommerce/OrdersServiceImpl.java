package com.distarise.base.service.impl.ecommerce;

import com.distarise.base.dao.ecommerce.OrdersDao;
import com.distarise.base.model.ecommerce.OrdersDto;
import com.distarise.base.service.ecommerce.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersDao ordersDao;

    @Override
    public OrdersDto save(OrdersDto order)
    {
        return ordersDao.save(order);
    }

    @Override
    public OrdersDto findById(Long id){return ordersDao.findById(id);}

}
