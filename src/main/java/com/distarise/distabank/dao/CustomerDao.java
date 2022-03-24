package com.distarise.distabank.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.distabank.model.CustomerDto;

import java.util.List;

public interface CustomerDao extends AbstractBaseDao {
    void saveCustomer(CustomerDto customerDto);
    List<CustomerDto> searchCustomer(String searchKey);
}
