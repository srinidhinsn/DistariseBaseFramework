package com.distarise.distabank.customer.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.distabank.customer.model.CustomerDto;

import java.util.List;

public interface CustomerDao extends AbstractBaseDao {
    void saveCustomer(CustomerDto customerDto);
    List<CustomerDto> searchCustomer(String clientId, String searchKey);
    List<CustomerDto> searchCustomerById(String clientId, Long searchKey);
    List<CustomerDto> findAllByClientId(String clientId);
}
