package com.distarise.base.service.ecommerce;

import com.distarise.base.model.ecommerce.CustomerDto;
import com.distarise.base.service.AbstractBaseService;

public interface CustomerService extends AbstractBaseService {
    CustomerDto save(CustomerDto customer);
    CustomerDto findById(Long id);
}
