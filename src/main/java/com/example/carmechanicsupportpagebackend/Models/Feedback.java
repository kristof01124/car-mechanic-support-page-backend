package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "FEEDBACK")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FEEDBACK_ID", nullable = false)
    private int feedback_id;

    //TODO
    //mappedby missing
    @ManyToOne
    private FeedbackOrderKT feedbackOrderKT;

    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;

    @Column(name = "START_TIME", nullable = false)
    private Date start_time;

    @Column(name = "END_TIME")
    private Date end_time;

    @Column(name = "COMMENT", length = 1000)
    private String comment;

    @Column(name = "IS_SUCCESSFUL")
    private boolean is_successful;

}
