package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_CAR_KT")
public class UserCarKT {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @ManyToOne
//    @JoinColumn(name = "USER_ID", nullable = false)
//    private User user;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @OneToOne
//    @JoinColumn(name = "CAR_ID", nullable = false)
//    private Car car;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false)
    private int USER_ID;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CAR_ID", nullable = false)
    private int CAR_ID;

    @OneToOne
    @JoinColumn(name="car_id")
    private Car car;

    public UserCarKT() {
    }

    public UserCarKT(int USER_ID, User user, int CAR_ID, Car car) {
        this.USER_ID = USER_ID;
        this.user = user;
        this.CAR_ID = CAR_ID;
        this.car = car;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public UserCarKT setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserCarKT setUser(User user) {
        this.user = user;
        return this;
    }

    public int getCAR_ID() {
        return CAR_ID;
    }

    public UserCarKT setCAR_ID(int CAR_ID) {
        this.CAR_ID = CAR_ID;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public UserCarKT setCar(Car car) {
        this.car = car;
        return this;
    }
}
