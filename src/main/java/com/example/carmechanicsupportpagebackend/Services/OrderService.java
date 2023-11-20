package com.example.carmechanicsupportpagebackend.Services;

import com.example.carmechanicsupportpagebackend.Dtos.OrderForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Dtos.UserForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryAlreadyExistsException;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Models.Order;
import com.example.carmechanicsupportpagebackend.Models.User;
import com.example.carmechanicsupportpagebackend.Repositories.OrderRepository;
import com.example.carmechanicsupportpagebackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> getOrderById(int id){
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public void addNewOrder(Order order){
        //No need to check if the same entry already exists, because many cars can have the same problem
        orderRepository.save(order);
    }

    public boolean deleteOrder(int orderId){
        Optional<Order> order = orderRepository.findById(orderId);

        if (order.isPresent()){
            orderRepository.deleteById(orderId);
            return true;
        }
        else return false;
    }

    //I hate Java for forcing me to use such an ugly solution, jesus christ
    @Transactional
    public void updateOrder(int orderId, OrderForUpdateDTO newValues){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntryNotFoundException("No such Order!"));

        if (newValues.severity() != null
                && !newValues.severity().isEmpty()){
            order.setSeverity(newValues.severity());
        }
        if (newValues.approximate_position() != null
                && !newValues.approximate_position().isEmpty()){
            order.setApproximate_position(newValues.approximate_position());
        }
        if (newValues.description() != null
                && !newValues.description().isEmpty()){
            order.setDescription(newValues.description());
        }

    }
}
