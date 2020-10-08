package com.distarise.ecommerce.service.impl;

import com.distarise.ecommerce.dao.OrdersDao;
import com.distarise.ecommerce.model.OrdersDto;
import com.distarise.ecommerce.service.OrdersService;
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
