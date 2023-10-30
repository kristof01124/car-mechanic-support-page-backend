package com.example.carmechanicsupportpagebackend.Models;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false, length = 50)
    private int id;

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String first_name;
    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String last_name;
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private Date date_of_birth;
    @Column(name = "PHONE_NUMBER", nullable = false, length = 15)
    private String phone_nuber;
    @Column(name = "EMAIL_ADDRESS", length = 50)
    private String email_address;
}
