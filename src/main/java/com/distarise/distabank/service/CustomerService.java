package com.distarise.distabank.service;

import com.distarise.base.service.AbstractBaseService;
import com.distarise.distabank.model.CustomerDto;

import java.util.List;

public interface CustomerService extends AbstractBaseService {
    void saveCustomer(CustomerDto customerDto);
    List<CustomerDto> searchCustomer(String searchKey);
    List<CustomerDto> searchCustomerById(Long searchKey);
}
