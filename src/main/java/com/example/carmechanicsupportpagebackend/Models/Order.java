package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", nullable = false)
    private int order_id;

    @OneToMany(mappedBy="order")
    private Set<FeedbackOrderKT> feedbackOrderKTSet;

    @OneToOne(mappedBy="order")
    private CarOrderKT carOrderKT;

    @Column(name = "SEVERITY", nullable = false, length = 50)
    private String severity;

    @Column(name = "APPROXIMATE_POSITION", nullable = false, length = 100)
    private String approximate_position;

    @Column(name = "DESCRIPTION", nullable = false, length = 400)
    private String description;

    public Order() {
    }

    public Order(int order_id, Set<FeedbackOrderKT> feedbackOrderKTSet, CarOrderKT carOrderKT, String severity, String approximate_position, String description) {
        this.order_id = order_id;
        this.feedbackOrderKTSet = feedbackOrderKTSet;
        this.carOrderKT = carOrderKT;
        this.severity = severity;
        this.approximate_position = approximate_position;
        this.description = description;
    }

    public int getOrder_id() {
        return order_id;
    }

    public Order setOrder_id(int order_id) {
        this.order_id = order_id;
        return this;
    }

    public Set<FeedbackOrderKT> getFeedbackOrderKTSet() {
        return feedbackOrderKTSet;
    }

    public Order setFeedbackOrderKTSet(Set<FeedbackOrderKT> feedbackOrderKTSet) {
        this.feedbackOrderKTSet = feedbackOrderKTSet;
        return this;
    }

    public CarOrderKT getCarOrderKT() {
        return carOrderKT;
    }

    public Order setCarOrderKT(CarOrderKT carOrderKT) {
        this.carOrderKT = carOrderKT;
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
