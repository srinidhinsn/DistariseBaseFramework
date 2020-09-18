package com.distarise.base.service.impl.amruthhani;

import com.distarise.base.dao.amruthhani.OrdersDao;
import com.distarise.base.model.amruthhani.OrdersDto;
import com.distarise.base.service.amruthhani.OrdersService;
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

}
