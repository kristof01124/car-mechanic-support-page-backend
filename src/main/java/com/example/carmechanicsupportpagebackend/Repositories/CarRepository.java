package com.example.carmechanicsupportpagebackend.Repositories;

import com.example.carmechanicsupportpagebackend.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    // You can add custom query methods if needed
}
