package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CAR_ID", nullable = false)
    private int car_id;

    @Column(name = "BRAND", nullable = false, length = 50)
    private String brand;

    @Column(name = "TYPE", nullable = false, length = 50)
    private String type;

    @Column(name = "LICENSE_PLATE", nullable = false, length = 10)
    private String license_plate;

    @Column(name = "SERIAL_NUMBER", length = 15)
    private String serial_number;

}
