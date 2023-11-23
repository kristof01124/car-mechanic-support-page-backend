package com.example.carmechanicsupportpagebackend.Models;

import com.example.carmechanicsupportpagebackend.Dtos.CarForCreationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id", nullable = false)
    private int car_id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id", referencedColumnName = "user_id")
    private User owner;

    @OneToMany(mappedBy="relatedCar")
    private Set<Order> relatedOrders = new HashSet<>();

    @Column(name = "BRAND", nullable = false, length = 50)
    private String brand;

    @Column(name = "TYPE", nullable = false, length = 50)
    private String type;

    @Column(name = "LICENSE_PLATE", nullable = false, length = 10)
    private String license_plate;

    @Column(name = "SERIAL_NUMBER", length = 15)
    private String serial_number;

    public Car() {
    }

    public Car(int car_id, User owner, String brand, String type, String license_plate, String serial_number) {
        this.car_id = car_id;
        this.owner = owner;
        this.brand = brand;
        this.type = type;
        this.license_plate = license_plate;
        this.serial_number = serial_number;
    }

    public Car(CarForCreationDTO other){
        this.brand = other.brand();
        this.type = other.type();
        this.license_plate = other.license_plate();
        this.serial_number = other.serial_number();
    }

    public int getCar_id() {
        return car_id;
    }

    public Car setCar_id(int car_id) {
        this.car_id = car_id;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public Car setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public Set<Order> getRelatedOrders() {
        return relatedOrders;
    }

    public Car setRelatedOrders(Set<Order> relatedOrders) {
        this.relatedOrders = relatedOrders;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getType() {
        return type;
    }

    public Car setType(String type) {
        this.type = type;
        return this;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public Car setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
        return this;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public Car setSerial_number(String serial_number) {
        this.serial_number = serial_number;
        return this;
    }
}
