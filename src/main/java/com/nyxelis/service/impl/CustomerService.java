package com.nyxelis.service.impl;

import com.nyxelis.entity.Customer;
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
  public Customer findById(Long id) {
    return customerRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
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
