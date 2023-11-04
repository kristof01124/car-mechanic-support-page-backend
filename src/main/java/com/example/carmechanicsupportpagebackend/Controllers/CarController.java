package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Dtos.*;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import com.example.carmechanicsupportpagebackend.Models.UserRoles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {
    //Replace these two variables when we have an actual DB
    List<CarDAO> shittyMockDB = new ArrayList<>();
    int entryIndexCounter=0;

    @GetMapping("/Cars")
    public ResponseEntity getCars(){
        return new ResponseEntity(shittyMockDB, HttpStatus.OK);
    }
    @GetMapping("/Cars/{id}")
    public ResponseEntity getCarById(@PathVariable int id){
        if (id<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");
        for (CarDAO car : shittyMockDB){
            if (car.getCar_id() == id){
                return new ResponseEntity<>(car, HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such car!");
    }

    @PostMapping("/Cars")
    public ResponseEntity createNewCar(@RequestBody CarForCreationDTO newCar){
        entryIndexCounter++;
        CarDAO carToAdd = new CarDAO(entryIndexCounter, newCar);

        shittyMockDB.add(carToAdd);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/Cars/{id}")
    public ResponseEntity updateCar(@PathVariable int id, @RequestBody CarForUpdateDTO carNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        for (CarDAO car : shittyMockDB){
            if (car.getCar_id() == id){
                car.setValuesToOtherCarDTO(carNewData);
                return new ResponseEntity<>(car, HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such car!");

    }

    @DeleteMapping("/Cars/{id}")
    public ResponseEntity deleteCar(@PathVariable int id){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        for (CarDAO car : shittyMockDB){
            if (car.getCar_id() == id){
                shittyMockDB.remove(car);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such entry!");
    }
}
