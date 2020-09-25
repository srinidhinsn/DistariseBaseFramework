package com.distarise.base.service.amruthhani;

import com.distarise.base.model.amruthhani.CustomerDto;
import com.distarise.base.service.AbstractBaseService;

public interface CustomerService extends AbstractBaseService {
    CustomerDto save(CustomerDto customer);
    CustomerDto findById(Long id);
}
