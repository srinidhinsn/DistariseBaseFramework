package com.distarise.base.dao.ecommerce;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.model.ecommerce.CustomerDto;

public interface CustomerDao extends AbstractBaseDao {
    CustomerDto save(CustomerDto customerDto);
    CustomerDto findById(Long id);
}
