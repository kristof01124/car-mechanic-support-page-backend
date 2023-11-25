package com.example.carmechanicsupportpagebackend.Services;

import com.example.carmechanicsupportpagebackend.Dtos.CarForCreationDTO;
import com.example.carmechanicsupportpagebackend.Dtos.CarForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Dtos.UserForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryAlreadyExistsException;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Models.Car;
import com.example.carmechanicsupportpagebackend.Models.User;
import com.example.carmechanicsupportpagebackend.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Optional<Car> getCarById(int id){
        return carRepository.findById(id);
    }
    public Optional<Car> getCarByLicensePlate(String license_plate){
        return carRepository.findCarByLicensePlate(license_plate);
    }

    public void addNewCar(Car car){
        Optional<Car> carOptional = carRepository.findCarByLicensePlate(car.getLicense_plate());
        if (carOptional.isPresent()){
            throw new EntryAlreadyExistsException("A car already exists with this license plate!");
        }
        carRepository.save(car);
    }

    public boolean deleteCar(int carId){
        Optional<Car> car = carRepository.findById(carId);

        if (car.isPresent()){
            carRepository.deleteById(carId);
            return true;
        }
        else return false;
    }

    //I hate Java for forcing me to use such an ugly solution, jesus christ
    @Transactional
    public void updateCar(int carId, CarForUpdateDTO newValues){
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new EntryNotFoundException("No such Car!"));

        if (newValues.brand() != null
                && !newValues.brand().isEmpty()){
            car.setBrand(newValues.brand());
        }
        if (newValues.type() != null
                && !newValues.type().isEmpty()){
            car.setType(newValues.type());
        }
        if (newValues.license_plate() !=null
            && !newValues.license_plate().isEmpty()){
            car.setLicense_plate(newValues.license_plate());
        }
        if (newValues.serial_number() != null
                && !newValues.serial_number().isEmpty()){
            car.setSerial_number(newValues.serial_number());
        }

    }
}
