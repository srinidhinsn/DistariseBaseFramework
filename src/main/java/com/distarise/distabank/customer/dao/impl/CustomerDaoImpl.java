package com.distarise.distabank.customer.dao.impl;

import com.distarise.distabank.customer.dao.CustomerDao;
import com.distarise.distabank.customer.entity.Customer;
import com.distarise.distabank.customer.model.CustomerDto;
import com.distarise.distabank.customer.repository.CustomerRepository;
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
    public List<CustomerDto> searchCustomer(String clientId, String searchKey) {
        List<Customer> customerList = customerRepository.findAllBySearchKey(clientId, searchKey);
        if (null == customerList){
            return null;
        }
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
    public List<CustomerDto> searchCustomerById(String clientId, Long searchKey) {
        Customer customer = customerRepository.findOne(searchKey);
        List<Customer> customerList = new ArrayList<>();
        if (null == customer){
            return null;
        }
        customerList.add(customer);
        return convertEntityToDtoList(customerList);
    }

    @Override
    public List<CustomerDto> findAllByClientId(String clientId) {
        List<Customer> customerList = customerRepository.findAllByClientId(clientId);
        if (null == customerList){
            return null;
        }
        return convertEntityToDtoList(customerList);
    }
}
