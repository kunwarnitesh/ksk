package com.ksk.entity;

import com.ksk.enums.CustomerType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "customer")
@Data
@NoArgsConstructor
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private CustomerType customerType;
}
