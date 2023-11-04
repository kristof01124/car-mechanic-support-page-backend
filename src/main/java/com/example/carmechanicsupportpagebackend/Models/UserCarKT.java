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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CAR_ID", nullable = false)
    private int CAR_ID;

}
