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

    public CarOrderKT() {
    }

    public CarOrderKT(int CAR_ID, Car car, int ORDER_ID, Order order) {
        this.CAR_ID = CAR_ID;
        this.car = car;
        this.ORDER_ID = ORDER_ID;
        this.order = order;
    }

    public int getCAR_ID() {
        return CAR_ID;
    }

    public CarOrderKT setCAR_ID(int CAR_ID) {
        this.CAR_ID = CAR_ID;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public CarOrderKT setCar(Car car) {
        this.car = car;
        return this;
    }

    public int getORDER_ID() {
        return ORDER_ID;
    }

    public CarOrderKT setORDER_ID(int ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public CarOrderKT setOrder(Order order) {
        this.order = order;
        return this;
    }
}
