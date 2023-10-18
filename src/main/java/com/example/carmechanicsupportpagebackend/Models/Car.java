package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int car_id;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "LICENSE_PLATE")
    private String license_plate;

    @Column(name = "SERIAL_NUMBER")
    private String serial_number;

}
