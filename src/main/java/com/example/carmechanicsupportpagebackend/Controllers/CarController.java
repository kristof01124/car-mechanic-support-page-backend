package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Dtos.CarForCreationDTO;
import com.example.carmechanicsupportpagebackend.Dtos.CarForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import com.example.carmechanicsupportpagebackend.Models.Car;
import com.example.carmechanicsupportpagebackend.Models.User;
import com.example.carmechanicsupportpagebackend.Services.CarService;
import com.example.carmechanicsupportpagebackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//TODO: TEST THIS
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {

    private final CarService carService;
    private final UserService userService;

    @Autowired
    public CarController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping("/Cars")
    public ResponseEntity getAllCars(){
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }
    @GetMapping("/Cars/{id}")
    public ResponseEntity getCarById(@PathVariable int id){
        if (id<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");

        Optional<Car> carById = carService.getCarById(id);
        if (carById.isPresent())
            return new ResponseEntity<>(carById.get(), HttpStatus.OK);
        else
            throw new EntryNotFoundException("No such car!");
    }

    @GetMapping("/Cars/license_plate/{license_plate}")
    public ResponseEntity getCarByLicensePlate(@PathVariable String license_plate){
        Optional<Car> carByLicensePlate = carService.getCarByLicensePlate(license_plate);
        if (carByLicensePlate.isPresent())
            return new ResponseEntity<>(carByLicensePlate.get(), HttpStatus.OK);
        else
            throw new EntryNotFoundException("No such car!");
    }

    @PostMapping("Users/{userid}/Cars")
    public ResponseEntity createNewCarWithOwner(@PathVariable int userid,@RequestBody CarForCreationDTO newCar){
        if (userid<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");

        Car carToAdd=new Car(newCar);

        Optional<User> owner=userService.getUserById(userid);

        if (owner.isPresent()){
            carToAdd.setOwner(owner.get());
            carService.addNewCar(carToAdd);

            return new ResponseEntity<>(carService.getCarByLicensePlate(newCar.license_plate()).get(),HttpStatus.CREATED);
        }
        else
            throw new EntryNotFoundException("No such user!");

    }

    @PatchMapping("/Cars/{id}")
    public ResponseEntity updateCar(@PathVariable int id, @RequestBody CarForUpdateDTO carNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        carService.updateCar(id, carNewData);

        return new ResponseEntity(carService.getCarById(id).get(),HttpStatus.OK);

    }

    @DeleteMapping("/Cars/{id}")
    public ResponseEntity deleteCar(@PathVariable int id){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        if (carService.deleteCar(id))
            return new ResponseEntity(HttpStatus.OK);
        else
            throw new EntryNotFoundException("No such car!");
    }
}
