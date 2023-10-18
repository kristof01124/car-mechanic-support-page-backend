package com.example.carmechanicsupportpagebackend.Models;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "FIRST_NAME")
    private String first_name;
    @Column(name = "LAST_NAME")
    private String last_name;
    @Column(name = "DATE_OF_BIRTH")
    private Date date_of_birth;
    @Column(name = "PHONE_NUMBER")
    private String phone_nuber;
    @Column(name = "EMAIL_ADDRESS")
    private String email_address;
}
