package com.example.carmechanicsupportpagebackend.Models;

import java.sql.Date;
import java.util.Objects;

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
    @Column(name = "USER_ROLE", length = 10)
    private String user_role;

    protected User() {}

    public User(int id, String first_name, String last_name, Date date_of_birth, String phone_nuber, String email_address, String user_role) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.phone_nuber = phone_nuber;
        this.email_address = email_address;
        this.user_role = user_role;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && first_name.equals(user.first_name) && last_name.equals(user.last_name) && date_of_birth.equals(user.date_of_birth) && phone_nuber.equals(user.phone_nuber) && email_address.equals(user.email_address) && user_role.equals(user.user_role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, date_of_birth, phone_nuber, email_address, user_role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", phone_nuber='" + phone_nuber + '\'' +
                ", email_address='" + email_address + '\'' +
                ", user_role='" + user_role + '\'' +
                '}';
    }
}
