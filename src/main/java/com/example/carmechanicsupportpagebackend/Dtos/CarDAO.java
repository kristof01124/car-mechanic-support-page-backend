package com.example.carmechanicsupportpagebackend.Dtos;

public class CarDAO {
    private int car_id;

    private String brand;

    private String type;

    private String license_plate;

    private String serial_number;

    public CarDAO(int car_id, String brand, String type, String license_plate, String serial_number) {
        this.car_id = car_id;
        this.brand = brand;
        this.type = type;
        this.license_plate = license_plate;
        this.serial_number = serial_number;
    }

    public CarDAO(int car_id, CarForCreationDTO other) {
        this.car_id = car_id;
        this.brand = other.brand();
        this.type = other.type();
        this.license_plate = other.license_plate();
        this.serial_number = other.serial_number();
    }
    public CarDAO(int car_id, CarForUpdateDTO other) {
        this.car_id = car_id;
        this.brand = other.brand();
        this.type = other.type();
        this.license_plate = other.license_plate();
        this.serial_number = other.serial_number();
    }

    public int getCar_id() {
        return car_id;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public void setValuesToOtherCarDTO(CarForCreationDTO other) {
        this.brand = other.brand();
        this.type = other.type();
        this.license_plate = other.license_plate();
        this.serial_number = other.serial_number();
    }

    public void setValuesToOtherCarDTO(CarForUpdateDTO other) {
        this.brand = other.brand();
        this.type = other.type();
        this.license_plate = other.license_plate();
        this.serial_number = other.serial_number();
    }
}
