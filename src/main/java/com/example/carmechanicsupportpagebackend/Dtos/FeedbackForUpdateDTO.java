package com.example.carmechanicsupportpagebackend.Dtos;

import java.sql.Date;

public record FeedbackForUpdateDTO(String title, Date start_time, Date end_time, String comment, boolean isSuccessful) {
}
