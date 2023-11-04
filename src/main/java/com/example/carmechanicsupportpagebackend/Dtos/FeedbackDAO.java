package com.example.carmechanicsupportpagebackend.Dtos;

import java.sql.Date;

public class FeedbackDAO {
    private int feedback_id;
    private String title;
    private Date start_time;
    private Date end_time;
    private String comment;
    private boolean is_successful;

    public FeedbackDAO(int feedback_id, String title, Date start_time, Date end_time, String comment, boolean is_successful) {
        this.feedback_id = feedback_id;
        this.title = title;
        this.start_time = start_time;
        this.end_time = end_time;
        this.comment = comment;
        this.is_successful = is_successful;
    }

    public FeedbackDAO(int feedback_id, FeedbackForCreationDTO other) {
        this.feedback_id = feedback_id;
        this.title = other.title();
        this.start_time = other.start_time();
        this.end_time = other.end_time();
        this.comment = other.comment();
        this.is_successful = other.isSuccessful();
    }

    public FeedbackDAO(int feedback_id, FeedbackForUpdateDTO other) {
        this.feedback_id = feedback_id;
        this.title = other.title();
        this.start_time = other.start_time();
        this.end_time = other.end_time();
        this.comment = other.comment();
        this.is_successful = other.isSuccessful();
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public String getTitle() {
        return title;
    }

    public Date getStart_time() {
        return start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public String getComment() {
        return comment;
    }

    public boolean isIs_successful() {
        return is_successful;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setIs_successful(boolean is_successful) {
        this.is_successful = is_successful;
    }

    public void setValuesToOtherFeedbackDTO(FeedbackForCreationDTO other) {
        this.title = other.title();
        this.start_time = other.start_time();
        this.end_time = other.end_time();
        this.comment = other.comment();
        this.is_successful = other.isSuccessful();
    }

    public void setValuesToOtherFeedbackDTO(FeedbackForUpdateDTO other) {
        this.title = other.title();
        this.start_time = other.start_time();
        this.end_time = other.end_time();
        this.comment = other.comment();
        this.is_successful = other.isSuccessful();
    }
}
