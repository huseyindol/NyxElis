package com.nyxelis.mapper;

import com.nyxelis.dto.DtoCustomer;
import com.nyxelis.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface CustomerMapper {
  DtoCustomer toCustomerDto(Customer customer);
}
