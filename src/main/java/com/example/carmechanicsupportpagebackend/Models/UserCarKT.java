package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_CAR_KT")
public class UserCarKT {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user_id;

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne
    @JoinColumn(name = "CAR_ID", nullable = false)
    private Car car_id;

}
