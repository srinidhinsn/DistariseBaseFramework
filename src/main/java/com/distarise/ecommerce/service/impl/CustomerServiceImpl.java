package com.distarise.ecommerce.service.impl;

import com.distarise.ecommerce.dao.CustomerDao;
import com.distarise.ecommerce.model.CustomerDto;
import com.distarise.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public CustomerDto save(CustomerDto customerDto)
    {
        return customerDao.save(customerDto);
    }

    @Override
    public CustomerDto findById(Long id)
    {
        return customerDao.findById(id);
    }
}
