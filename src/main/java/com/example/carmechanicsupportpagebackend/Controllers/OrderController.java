package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Dtos.OrderForCreationDTO;
import com.example.carmechanicsupportpagebackend.Dtos.OrderForUpdateDTO;
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

import java.util.Optional;


//TODO: TEST THIS
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    private final OrderService orderService;
    private final CarService carService;

    @Autowired
    public OrderController(OrderService orderService, CarService carService) {
        this.orderService = orderService;
        this.carService = carService;
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

    @PostMapping("Cars/{carid}/Orders")
    public ResponseEntity createNewOrderWithRelatedCar(@PathVariable int carid,@RequestBody OrderForCreationDTO newOrder){
        if (carid<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");

        Optional<Car> carById = carService.getCarById(carid);
        if (carById.isPresent())
        {
            Order orderToAdd=new Order(newOrder);
            orderToAdd.setRelatedCar(carById.get());

            orderService.addNewOrder(orderToAdd);

            return new ResponseEntity<>(orderService.getOrderByDescription(newOrder.description()).get(),HttpStatus.CREATED);
        }
        else throw new EntryNotFoundException("No such car!");
    }

    @PatchMapping("/Orders/{id}")
    public ResponseEntity updateOrder(@PathVariable int id, @RequestBody OrderForUpdateDTO orderNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        orderService.updateOrder(id, orderNewData);

        return new ResponseEntity(orderService.getOrderById(id).get(),HttpStatus.OK);

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
