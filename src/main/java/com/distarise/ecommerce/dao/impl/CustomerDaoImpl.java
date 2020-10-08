package com.distarise.ecommerce.dao.impl;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.ecommerce.dao.CustomerDao;
import com.distarise.ecommerce.entity.Customer;
import com.distarise.ecommerce.model.CustomerDto;
import com.distarise.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDaoImpl implements AbstractBaseDao, CustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerDto save(CustomerDto customerDto){
        Customer customer = customerRepository.save(modelMapper.map(customerDto, Customer.class));
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto findById(Long id){
        Customer customer = customerRepository.findById(id);
        return modelMapper.map(customer, CustomerDto.class);
    }

}
