package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int car_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CAR_ID", referencedColumnName = "CAR_ID")
    private UserCarKT userCarKT;

    @OneToMany(mappedBy="car")
    private Set<CarOrderKT> carOrderKTSet;

    @Column(name = "BRAND", nullable = false, length = 50)
    private String brand;

    @Column(name = "TYPE", nullable = false, length = 50)
    private String type;

    @Column(name = "LICENSE_PLATE", nullable = false, length = 10)
    private String license_plate;

    @Column(name = "SERIAL_NUMBER", length = 15)
    private String serial_number;

    protected Car() {}
    public Car(int car_id, String brand, String type, String license_plate, String serial_number) {
        this.car_id = car_id;
        this.brand = brand;
        this.type = type;
        this.license_plate = license_plate;
        this.serial_number = serial_number;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return car_id == car.car_id && brand.equals(car.brand) && type.equals(car.type) && license_plate.equals(car.license_plate) && serial_number.equals(car.serial_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car_id, brand, type, license_plate, serial_number);
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", serial_number='" + serial_number + '\'' +
                '}';
    }
}
