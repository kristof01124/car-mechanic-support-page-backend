package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "FEEDBACK")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int feedback_id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "START_TIME")
    private int start_time;

    @Column(name = "END_TIME")
    private Date end_time;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "IS_SUCCESSFUL")
    private boolean is_successful;

}
