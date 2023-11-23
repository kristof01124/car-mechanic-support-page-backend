package com.example.carmechanicsupportpagebackend.Models;

import com.example.carmechanicsupportpagebackend.Dtos.OrderForCreationDTO;
import com.example.carmechanicsupportpagebackend.Dtos.OrderForUpdateDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", nullable = false)
    private int order_id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="car_id", referencedColumnName = "car_id")
    private Car relatedCar;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feedback_id", referencedColumnName = "feedback_id")
    private Feedback relatedFeedback;



    @Column(name = "SEVERITY", nullable = false, length = 50)
    private String severity;

    @Column(name = "APPROXIMATE_POSITION", nullable = false, length = 100)
    private String approximate_position;

    @Column(name = "DESCRIPTION", nullable = false, length = 400)
    private String description;

    public Order() {
    }

    public Order(int order_id, Feedback relatedFeedback, Car relatedCar, String severity, String approximate_position, String description) {
        this.order_id = order_id;
        this.relatedFeedback = relatedFeedback;
        this.relatedCar = relatedCar;
        this.severity = severity;
        this.approximate_position = approximate_position;
        this.description = description;
    }

    public Order(OrderForUpdateDTO other) {
        this.severity = other.severity();
        this.approximate_position = other.approximate_position();
        this.description = other.description();
    }
    public Order(OrderForCreationDTO other) {
        this.severity = other.severity();
        this.approximate_position = other.approximate_position();
        this.description = other.description();
    }

    public int getOrder_id() {
        return order_id;
    }

    public Order setOrder_id(int order_id) {
        this.order_id = order_id;
        return this;
    }

    public Feedback getRelatedFeedback() {
        return relatedFeedback;
    }

    public Order setRelatedFeedback(Feedback relatedFeedback) {
        this.relatedFeedback = relatedFeedback;
        return this;
    }

    public Car getRelatedCar() {
        return relatedCar;
    }

    public Order setRelatedCar(Car relatedCar) {
        this.relatedCar = relatedCar;
        return this;
    }

    public String getSeverity() {
        return severity;
    }

    public Order setSeverity(String severity) {
        this.severity = severity;
        return this;
    }

    public String getApproximate_position() {
        return approximate_position;
    }

    public Order setApproximate_position(String approximate_position) {
        this.approximate_position = approximate_position;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Order setDescription(String description) {
        this.description = description;
        return this;
    }
}
