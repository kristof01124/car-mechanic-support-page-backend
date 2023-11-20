package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Dtos.*;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import com.example.carmechanicsupportpagebackend.Models.Car;
import com.example.carmechanicsupportpagebackend.Models.Order;
import com.example.carmechanicsupportpagebackend.Services.CarService;
import com.example.carmechanicsupportpagebackend.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//TODO: TEST THIS
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/Orders")
    public ResponseEntity getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }
    @GetMapping("/Orders/{id}")
    public ResponseEntity getOrderById(@PathVariable int id){
        if (id<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");

        Optional<Order> orderById = orderService.getOrderById(id);
        if (orderById.isPresent())
            return new ResponseEntity<>(orderById.get(), HttpStatus.OK);
        else
            throw new EntryNotFoundException("No such order!");
    }

    @PostMapping("/Orders")
    public ResponseEntity createNewOrder(@RequestBody OrderForCreationDTO newOrder){
        Order orderToAdd=new Order(newOrder);

        orderService.addNewOrder(orderToAdd);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/Orders/{id}")
    public ResponseEntity updateOrder(@PathVariable int id, @RequestBody OrderForUpdateDTO orderNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        orderService.updateOrder(id, orderNewData);

        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("/Orders/{id}")
    public ResponseEntity deleteOrder(@PathVariable int id){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        if (orderService.deleteOrder(id))
            return new ResponseEntity(HttpStatus.OK);
        else
            throw new EntryNotFoundException("No such order!");
    }
}
