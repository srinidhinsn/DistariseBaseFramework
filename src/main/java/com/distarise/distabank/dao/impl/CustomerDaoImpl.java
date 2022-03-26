package com.distarise.distabank.dao.impl;

import com.distarise.distabank.dao.CustomerDao;
import com.distarise.distabank.entity.Customer;
import com.distarise.distabank.model.CustomerDto;
import com.distarise.distabank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        customerRepository.save(modelMapper.map(customerDto, Customer.class));
    }

    @Override
    public List<CustomerDto> searchCustomer(String searchKey) {
        List<Customer> customerList = customerRepository.findAllBySearchKey(searchKey);
        return convertEntityToDtoList(customerList);
    }

    private List<CustomerDto> convertEntityToDtoList(List<Customer> customerList){
        if (null == customerList){
            return new ArrayList<>();
        }
        return customerList.stream().map(customer ->
                modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> searchCustomerById(Long searchKey) {
        Customer customer = customerRepository.findOne(searchKey);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        return convertEntityToDtoList(customerList);
    }
}
