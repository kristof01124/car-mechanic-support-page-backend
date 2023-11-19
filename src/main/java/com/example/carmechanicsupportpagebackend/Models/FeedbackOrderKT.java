package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "FEEDBACK_ORDER_KT")
public class FeedbackOrderKT {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @ManyToOne
//    @JoinColumn(name = "ORDER_ID", nullable = false)
//    private Order order;
//
//    @OneToMany(mappedBy="FEEDBACK_ODER")
//    private Set<Feedback> feedbackSet;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FEEDBACK_ID", nullable = false)
    private int FEEDBACK_ID;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", nullable = false)
    private int ORDER_ID;

    @OneToOne
    @JoinColumn(name="feedback_id")
    private Feedback feedback;

    public FeedbackOrderKT() {
    }

    public FeedbackOrderKT(int FEEDBACK_ID, Order order, int ORDER_ID, Feedback feedback) {
        this.FEEDBACK_ID = FEEDBACK_ID;
        this.order = order;
        this.ORDER_ID = ORDER_ID;
        this.feedback = feedback;
    }

    public int getFEEDBACK_ID() {
        return FEEDBACK_ID;
    }

    public FeedbackOrderKT setFEEDBACK_ID(int FEEDBACK_ID) {
        this.FEEDBACK_ID = FEEDBACK_ID;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public FeedbackOrderKT setOrder(Order order) {
        this.order = order;
        return this;
    }

    public int getORDER_ID() {
        return ORDER_ID;
    }

    public FeedbackOrderKT setORDER_ID(int ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
        return this;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public FeedbackOrderKT setFeedback(Feedback feedback) {
        this.feedback = feedback;
        return this;
    }
}
