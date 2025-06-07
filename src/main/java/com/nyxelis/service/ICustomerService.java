package com.nyxelis.service;

import com.nyxelis.dto.DtoCustomer;

public interface ICustomerService {
    public DtoCustomer findById(Long id);
    public void removeById(Long id);
}
