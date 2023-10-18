package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;

    @Column(name = "SEVERITY")
    private String severity;

    @Column(name = "APPROXIMATE_POSITION")
    private String approximate_position;

    @Column(name = "DESCRIPTION")
    private String description;
}
