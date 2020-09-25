package com.distarise.base.service.impl.amruthhani;

import com.distarise.base.dao.amruthhani.CustomerDao;
import com.distarise.base.dao.amruthhani.OrdersDao;
import com.distarise.base.model.amruthhani.CustomerDto;
import com.distarise.base.model.amruthhani.OrdersDto;
import com.distarise.base.service.amruthhani.CustomerService;
import com.distarise.base.service.amruthhani.OrdersService;
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
