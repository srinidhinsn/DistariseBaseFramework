package com.distarise.distabank.service.impl;

import com.distarise.distabank.dao.CustomerDao;
import com.distarise.distabank.model.CustomerDto;
import com.distarise.distabank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        customerDao.saveCustomer(customerDto);
    }

    @Override
    public List<CustomerDto> searchCustomer(String searchKey) {
        List<CustomerDto> customerDtoList = customerDao.searchCustomer(searchKey);
        return customerDtoList;
    }
}
