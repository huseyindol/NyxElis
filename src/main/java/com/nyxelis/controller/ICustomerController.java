package com.nyxelis.controller;

import com.nyxelis.dto.DtoCustomer;

public interface ICustomerController {
  DtoCustomer findById(Long id);

  void removeById(Long id);
}
