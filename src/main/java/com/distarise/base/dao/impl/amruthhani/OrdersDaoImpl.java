package com.distarise.base.dao.impl.amruthhani;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.dao.amruthhani.OrdersDao;
import com.distarise.base.dao.amruthhani.ProductDao;
import com.distarise.base.entity.amruthhani.Orders;
import com.distarise.base.entity.amruthhani.Product;
import com.distarise.base.model.amruthhani.OrdersDto;
import com.distarise.base.model.amruthhani.ProductDto;
import com.distarise.base.repository.amruthhani.OrdersRepository;
import com.distarise.base.repository.amruthhani.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
