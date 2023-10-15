package com.example.carmechanicsupportpagebackend.Models;

import org.springframework.lang.Nullable;

import java.sql.Date;

public record UserForCreationDTO (String first_name, String last_name, Date date_of_birth, String phone_number, @Nullable String email_address) {
}
