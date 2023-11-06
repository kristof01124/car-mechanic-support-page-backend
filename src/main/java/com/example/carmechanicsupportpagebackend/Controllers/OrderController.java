package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Dtos.*;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    //Replace these two variables when we have an actual DB
    List<OrderDAO> shittyMockDB = new ArrayList<>();
    int entryIndexCounter=0;

    @GetMapping("/Orders")
    public ResponseEntity getOrders(){
        return new ResponseEntity(shittyMockDB, HttpStatus.OK);
    }
    @GetMapping("/Orders/{id}")
    public ResponseEntity getOrderById(@PathVariable int id){
        if (id<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");
        for (OrderDAO order : shittyMockDB){
            if (order.getOrder_id() == id){
                return new ResponseEntity<>(order, HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such order!");
    }

    @PostMapping("/Orders")
    public ResponseEntity createNewCar(@RequestBody OrderForCreationDTO newOrder){
        entryIndexCounter++;
        OrderDAO orderToAdd = new OrderDAO(entryIndexCounter, newOrder);

        shittyMockDB.add(orderToAdd);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/Orders/{id}")
    public ResponseEntity updateCar(@PathVariable int id, @RequestBody OrderForUpdateDTO orderNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        for (OrderDAO order : shittyMockDB){
            if (order.getOrder_id() == id){
                order.setValuesToOtherOrderDTO(orderNewData);
                return new ResponseEntity<>(order, HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such car!");

    }

    @DeleteMapping("/Orders/{id}")
    public ResponseEntity deleteCar(@PathVariable int id){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        for (OrderDAO order : shittyMockDB){
            if (order.getOrder_id() == id){
                shittyMockDB.remove(order);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such entry!");
    }
}
