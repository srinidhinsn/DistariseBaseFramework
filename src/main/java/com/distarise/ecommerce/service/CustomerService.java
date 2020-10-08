package com.distarise.ecommerce.service;

import com.distarise.ecommerce.model.CustomerDto;
import com.distarise.base.service.AbstractBaseService;

public interface CustomerService extends AbstractBaseService {
    CustomerDto save(CustomerDto customer);
    CustomerDto findById(Long id);
}
