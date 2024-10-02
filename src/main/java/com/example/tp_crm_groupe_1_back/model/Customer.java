package com.example.tp_crm_groupe_1_back.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "COMPANY_NAME", length = 100, nullable = false)
    private String companyName;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 15, unique = true)
    private String phoneNumber;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "ZIP_CODE", length = 30, nullable = false)
    private String zipCode;

    @Column(name = "COUNTRY", length = 100, nullable = false)
    private String country;

    @Column(name = "CITY", length = 100, nullable = false)
    private String city;

    @Column(name = "STATE")
    private Integer state;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> oders;
}
