package com.distarise.base.service.impl.ecommerce;

import com.distarise.base.dao.ecommerce.CustomerDao;
import com.distarise.base.model.ecommerce.CustomerDto;
import com.distarise.base.service.ecommerce.CustomerService;
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
