package com.nyxelis.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer_details")
@Getter
@Setter
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
