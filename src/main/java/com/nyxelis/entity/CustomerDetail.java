package com.nyxelis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String phoneNumber;

    private String email;
}
