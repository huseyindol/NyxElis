package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomer {
    private String name;
    private String email;
    private String firstName;
    private String lastName;
    private DtoCustomerToCustomerDetail details;
}
