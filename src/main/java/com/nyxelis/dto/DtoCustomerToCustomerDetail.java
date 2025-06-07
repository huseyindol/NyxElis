package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomerToCustomerDetail {
    private String address;

    private String phoneNumber;

    private String email;
}
