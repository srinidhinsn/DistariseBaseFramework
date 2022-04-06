package com.distarise.distabank.customer.service.impl;

import com.distarise.distabank.customer.dao.CustomerDao;
import com.distarise.distabank.customer.model.CustomerDto;
import com.distarise.distabank.customer.service.CustomerService;
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
    public List<CustomerDto> searchCustomer(String clientId, String searchKey) {
        Set<CustomerDto> finalCustomerDtoList = new HashSet<>();
        List<CustomerDto> customerDtos = new ArrayList<>();
        if (DistabankUtils.isNumeric(searchKey)){
            finalCustomerDtoList.addAll(searchCustomerById(clientId, Long.parseLong(searchKey)));
        }
        customerDtos = customerDao.searchCustomer(clientId, searchKey.toLowerCase());
        if (null != customerDtos){
            finalCustomerDtoList.addAll(customerDtos);
        }

        customerDtos = customerDao.findAllByClientId(clientId);
        if (null != customerDtos){
            finalCustomerDtoList.addAll(customerDtos);
        }

        return new ArrayList<>(finalCustomerDtoList);
    }

    @Override
    public List<CustomerDto> searchCustomerById(String clientId, Long searchKey) {
        List<CustomerDto> customerDtoList = customerDao.searchCustomerById(clientId, searchKey);
        return customerDtoList;
    }
}
