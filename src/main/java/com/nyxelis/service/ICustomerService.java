package com.nyxelis.service;

import com.nyxelis.entity.Customer;

public interface ICustomerService {
  Customer findById(Long id);

  void removeById(Long id);
}
