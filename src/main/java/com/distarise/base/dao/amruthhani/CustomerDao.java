package com.distarise.base.dao.amruthhani;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.model.amruthhani.CustomerDto;

public interface CustomerDao extends AbstractBaseDao {
    CustomerDto save(CustomerDto customerDto);
    CustomerDto findById(Long id);
}
