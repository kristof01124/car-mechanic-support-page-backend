package com.example.carmechanicsupportpagebackend.Models;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false, length = 50)
    private int user_id;
    @OneToMany(mappedBy="user")
    private Set<UserCarKT> userCarKTSet;

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
    @Column(name = "USER_ROLE", length = 10)
    private String user_role;

    public User() {
    }

    public User(int user_id, Set<UserCarKT> userCarKTSet, String first_name, String last_name, Date date_of_birth, String phone_nuber, String email_address, String user_role) {
        this.user_id = user_id;
        this.userCarKTSet = userCarKTSet;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.phone_nuber = phone_nuber;
        this.email_address = email_address;
        this.user_role = user_role;
    }

    public int getUser_id() {
        return user_id;
    }

    public User setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public Set<UserCarKT> getUserCarKTSet() {
        return userCarKTSet;
    }

    public User setUserCarKTSet(Set<UserCarKT> userCarKTSet) {
        this.userCarKTSet = userCarKTSet;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public User setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public User setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public User setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
        return this;
    }

    public String getPhone_nuber() {
        return phone_nuber;
    }

    public User setPhone_nuber(String phone_nuber) {
        this.phone_nuber = phone_nuber;
        return this;
    }

    public String getEmail_address() {
        return email_address;
    }

    public User setEmail_address(String email_address) {
        this.email_address = email_address;
        return this;
    }

    public String getUser_role() {
        return user_role;
    }

    public User setUser_role(String user_role) {
        this.user_role = user_role;
        return this;
    }
}
