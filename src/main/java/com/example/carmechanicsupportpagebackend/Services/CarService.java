package com.example.carmechanicsupportpagebackend.Services;

import com.example.carmechanicsupportpagebackend.Models.Car;
import com.example.carmechanicsupportpagebackend.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
