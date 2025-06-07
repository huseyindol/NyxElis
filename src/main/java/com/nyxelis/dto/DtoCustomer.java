package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomer {

    private String name;

    private DtoCustomerToCustomerDetail details;
}
