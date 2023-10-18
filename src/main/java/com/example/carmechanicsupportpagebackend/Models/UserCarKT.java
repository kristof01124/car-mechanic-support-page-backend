package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_CAR_KT")
public class UserCarKT {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int car_id;

}
