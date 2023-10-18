package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "CAR_ORDER_KT")
public class CarOrderKT {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int car_id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;

}
