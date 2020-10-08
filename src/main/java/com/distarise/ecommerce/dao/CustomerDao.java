package com.distarise.ecommerce.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.ecommerce.model.CustomerDto;

public interface CustomerDao extends AbstractBaseDao {
    CustomerDto save(CustomerDto customerDto);
    CustomerDto findById(Long id);
}
