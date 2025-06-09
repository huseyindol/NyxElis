package com.nyxelis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomer {

    private String name;

    private DtoCustomerToCustomerDetail details;
}
