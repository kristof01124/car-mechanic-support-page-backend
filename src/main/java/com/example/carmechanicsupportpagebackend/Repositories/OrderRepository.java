package com.example.carmechanicsupportpagebackend.Repositories;

import com.example.carmechanicsupportpagebackend.Models.Order;
import com.example.carmechanicsupportpagebackend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
