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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", nullable = false)
    private int ORDER_ID;
}
