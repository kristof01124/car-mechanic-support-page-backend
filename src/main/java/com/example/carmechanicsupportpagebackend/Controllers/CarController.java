package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Dtos.CarForCreationDTO;
import com.example.carmechanicsupportpagebackend.Dtos.CarForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import com.example.carmechanicsupportpagebackend.Models.Car;
import com.example.carmechanicsupportpagebackend.Services.CarService;
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

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
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

    @PostMapping("/Cars")
    public ResponseEntity createNewCar(@RequestBody CarForCreationDTO newCar){
        Car carToAdd=new Car(newCar);

        carService.addNewCar(carToAdd);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/Cars/{id}")
    public ResponseEntity updateCar(@PathVariable int id, @RequestBody CarForUpdateDTO carNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        carService.updateCar(id, carNewData);

        return new ResponseEntity(HttpStatus.OK);

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
