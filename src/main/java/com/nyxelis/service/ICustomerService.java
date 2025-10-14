package com.nyxelis.service;

import com.nyxelis.dto.DtoCustomer;

public interface ICustomerService {
  DtoCustomer findById(Long id);

  void removeById(Long id);
}
