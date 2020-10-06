package com.distarise.base.dao.impl.ecommerce;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.dao.ecommerce.OrdersDao;
import com.distarise.base.entity.ecommerce.Orders;
import com.distarise.base.model.ecommerce.OrdersDto;
import com.distarise.base.repository.ecommerce.OrdersRepository;
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
