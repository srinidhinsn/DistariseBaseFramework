package com.distarise.distabank.customer.service;

import com.distarise.base.service.AbstractBaseService;
import com.distarise.distabank.customer.model.CustomerDto;

import java.util.List;

public interface CustomerService extends AbstractBaseService {
    void saveCustomer(CustomerDto customerDto);
    List<CustomerDto> searchCustomer(String clientId, String searchKey);
    List<CustomerDto> searchCustomerById(String clientId, Long searchKey);
}
