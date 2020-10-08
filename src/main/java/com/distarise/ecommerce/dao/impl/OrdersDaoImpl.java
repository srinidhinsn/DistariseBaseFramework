package com.distarise.ecommerce.dao.impl;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.ecommerce.dao.OrdersDao;
import com.distarise.ecommerce.entity.Orders;
import com.distarise.ecommerce.model.OrdersDto;
import com.distarise.ecommerce.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdersDaoImpl implements AbstractBaseDao, OrdersDao {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public OrdersDto save(OrdersDto ordersDto){
        Orders orders = ordersRepository.save(modelMapper.map(ordersDto, Orders.class));
        return modelMapper.map(orders, OrdersDto.class);
    }

    @Override
    public OrdersDto findById(Long id){
        Orders orders = ordersRepository.findById(id);
        return modelMapper.map(orders, OrdersDto.class);
    }

}
