package com.example.carmechanicsupportpagebackend.Models;

import java.sql.Date;


public class UserDAO {

    int user_id;
    String first_name;
    String last_name;
    Date date_of_birth;
    String phone_number;

    String email_address;

    //TODO: Figure out how to store enums using JPA
    String user_role;

    public UserDAO(int user_id, String first_name, String last_name, Date date_of_birth, String phone_number, String email_address, String user_role) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.email_address = email_address;
        this.user_role = user_role;
    }

    public UserDAO(int user_id, UserForUpdateDTO other){
        this.user_id = user_id;
        this.first_name = other.first_name();
        this.last_name = other.last_name();
        this.date_of_birth = other.date_of_birth();
        this.phone_number = other.phone_number();
        this.email_address = other.email_address();
        this.user_role = other.user_role();
    }

    public UserDAO(int user_id, UserForCreationDTO other){
        this.user_id = user_id;
        this.first_name = other.first_name();
        this.last_name = other.last_name();
        this.date_of_birth = other.date_of_birth();
        this.phone_number = other.phone_number();
        this.email_address = other.email_address();
        this.user_role = other.user_role();
    }

    public UserDAO() {
    }

    public int getUser_id() {
        return user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public void setValuesToOtherUserDTO(UserForUpdateDTO other){
        this.first_name = other.first_name();
        this.last_name = other.last_name();
        this.date_of_birth = other.date_of_birth();
        this.phone_number = other.phone_number();
        this.email_address = other.email_address();
        this.user_role = other.user_role();
    }

    public void setValuesToOtherUserDTO(UserForCreationDTO other){
        this.first_name = other.first_name();
        this.last_name = other.last_name();
        this.date_of_birth = other.date_of_birth();
        this.phone_number = other.phone_number();
        this.email_address = other.email_address();
        this.user_role = other.user_role();
    }
}
