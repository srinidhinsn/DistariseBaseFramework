package com.distarise.base.dao.impl.ecommerce;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.dao.ecommerce.CustomerDao;
import com.distarise.base.entity.ecommerce.Customer;
import com.distarise.base.model.ecommerce.CustomerDto;
import com.distarise.base.repository.ecommerce.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDaoImpl implements AbstractBaseDao, CustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerDto save(CustomerDto customerDto){
        Customer customer = customerRepository.save(modelMapper.map(customerDto, Customer.class));
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto findById(Long id){
        Customer customer = customerRepository.findById(id);
        return modelMapper.map(customer, CustomerDto.class);
    }

}
