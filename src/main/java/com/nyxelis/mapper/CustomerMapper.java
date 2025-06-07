package com.nyxelis.mapper;

import com.nyxelis.dto.DtoCustomer;
import com.nyxelis.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    DtoCustomer toDto(Customer customer);
    Customer toEntity(DtoCustomer dtoCustomer);
}
