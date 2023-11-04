package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "CAR_ORDER_KT")
public class CarOrderKT {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @ManyToOne
//    @JoinColumn(name = "CAR_ID", nullable = false)
//    private Car car;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @OneToOne
//    @JoinColumn(name = "ORDER_ID", nullable = false)
//    private Order order;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CAR_ID", nullable = false)
    private int CAR_ID;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", nullable = false)
    private int ORDER_ID;

    @OneToOne
    @JoinColumn(name="order_id")
    private Order order;

}
