package com.example.tp_crm_groupe_1_back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_type", length = 100, nullable = false)
    private String serviceType;

    @Column(name = "NB_DAYS", nullable = false)
    private int nbDays;

    @Column(name = "TVA", nullable = false)
    private BigDecimal tva;

    @Column(name = "TOTAL_EXCLUDE_TAX", nullable = false)
    private BigDecimal totalExcludeTax;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATE", nullable = true)
    private OrderState state;

    @Column(name = "COMMENT", nullable = true)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "customer_id" ,nullable = true)
    private Customer  customer;






}
