package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "FEEDBACK_ORDER_KT")
public class FeedbackOrderKT {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int feedback_id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_in;
}
