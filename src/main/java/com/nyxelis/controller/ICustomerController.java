package com.nyxelis.controller;

import com.nyxelis.dto.DtoCustomer;

public interface ICustomerController {
    public DtoCustomer findById(Long id);
    public void removeById(Long id);
}
