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
    @Column(name = "car_id", nullable = false)
    private int car_id;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", nullable = false)
    private int order_id;

    @OneToOne
    @JoinColumn(name="order_id")
    private Order order;

    public CarOrderKT() {
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int ORDER_ID) {
        this.order_id = ORDER_ID;
    }
}
