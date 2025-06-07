package com.nyxelis.service.impl;

import com.nyxelis.dto.DtoCustomer;
import com.nyxelis.entity.Customer;
import com.nyxelis.mapper.CustomerMapper;
import com.nyxelis.repository.CustomerRepository;
import com.nyxelis.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            return null; // or throw an exception, depending on your error handling strategy
        }
        Customer customerDb = optionalCustomer.get();
        DtoCustomer dtoCustomer = CustomerMapper.INSTANCE.toDto(customerDb);
        return dtoCustomer;
    }

    @Override
    public void removeById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            return; // or throw an exception, depending on your error handling strategy
        }
        Customer customerDb = optionalCustomer.get();
        customerRepository.delete(customerDb);
    }
}
