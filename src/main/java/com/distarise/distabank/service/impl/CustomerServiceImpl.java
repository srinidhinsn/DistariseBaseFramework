package com.distarise.distabank.service.impl;

import com.distarise.distabank.dao.CustomerDao;
import com.distarise.distabank.model.CustomerDto;
import com.distarise.distabank.service.CustomerService;
import com.distarise.distabank.util.DistabankUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<CustomerDto> customerDtoList = new HashSet<>();
        if (DistabankUtils.isNumeric(searchKey)){
            customerDtoList.addAll(searchCustomerById(Long.parseLong(searchKey)));
        } else {
            customerDtoList.addAll(customerDao.searchCustomer(searchKey.toLowerCase()));
        }
        return new ArrayList<>(customerDtoList);
    }

    @Override
    public List<CustomerDto> searchCustomerById(Long searchKey) {
        List<CustomerDto> customerDtoList = customerDao.searchCustomerById(searchKey);
        return customerDtoList;
    }
}
