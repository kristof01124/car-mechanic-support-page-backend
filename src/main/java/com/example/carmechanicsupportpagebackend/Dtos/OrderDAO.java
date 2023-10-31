package com.example.carmechanicsupportpagebackend.Dtos;

public class OrderDAO {
    private int order_id;

    private String severity;

    private String approximate_position;

    private String description;

    public OrderDAO(int order_id, String severity, String approximate_position, String description) {
        this.order_id = order_id;
        this.severity = severity;
        this.approximate_position = approximate_position;
        this.description = description;
    }

    public OrderDAO(int order_id, OrderForCreationDTO other) {
        this.order_id = order_id;
        this.severity = other.severity();
        this.approximate_position = other.approximate_position();
        this.description = other.description();
    }

    public OrderDAO(int order_id, OrderForUpdateDTO other) {
        this.order_id = order_id;
        this.severity = other.severity();
        this.approximate_position = other.approximate_position();
        this.description = other.description();
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getSeverity() {
        return severity;
    }

    public String getApproximate_position() {
        return approximate_position;
    }

    public String getDescription() {
        return description;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setApproximate_position(String approximate_position) {
        this.approximate_position = approximate_position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValuesToOtherOrderDTO(OrderForCreationDTO other) {
        this.severity = other.severity();
        this.approximate_position = other.approximate_position();
        this.description = other.description();
    }

    public void setValuesToOtherOrderDTO(OrderForUpdateDTO other) {
        this.severity = other.severity();
        this.approximate_position = other.approximate_position();
        this.description = other.description();
    }
}
