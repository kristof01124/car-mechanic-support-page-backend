package com.example.carmechanicsupportpagebackend.dto;

import org.springframework.lang.Nullable;

import java.sql.Date;

public record UserForCreationDTO (String first_name, String last_name, Date date_of_birth, String phone_number, String email_address, String user_role) {
}
