package com.example.carmechanicsupportpagebackend.Models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "FEEDBACK")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FEEDBACK_ID", nullable = false)
    private int feedback_id;

    @OneToOne(mappedBy="feedback")
    private FeedbackOrderKT feedbackOrderKT;

    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;

    @Column(name = "START_TIME", nullable = false)
    private Date start_time;

    @Column(name = "END_TIME")
    private Date end_time;

    @Column(name = "COMMENT", length = 1000)
    private String comment;

    @Column(name = "IS_SUCCESSFUL")
    private boolean is_successful;

    public Feedback() {
    }

    public Feedback(int feedback_id, FeedbackOrderKT feedbackOrderKT, String title, Date start_time, Date end_time, String comment, boolean is_successful) {
        this.feedback_id = feedback_id;
        this.feedbackOrderKT = feedbackOrderKT;
        this.title = title;
        this.start_time = start_time;
        this.end_time = end_time;
        this.comment = comment;
        this.is_successful = is_successful;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public Feedback setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
        return this;
    }

    public FeedbackOrderKT getFeedbackOrderKT() {
        return feedbackOrderKT;
    }

    public Feedback setFeedbackOrderKT(FeedbackOrderKT feedbackOrderKT) {
        this.feedbackOrderKT = feedbackOrderKT;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Feedback setTitle(String title) {
        this.title = title;
        return this;
    }

    public Date getStart_time() {
        return start_time;
    }

    public Feedback setStart_time(Date start_time) {
        this.start_time = start_time;
        return this;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public Feedback setEnd_time(Date end_time) {
        this.end_time = end_time;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Feedback setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public boolean isIs_successful() {
        return is_successful;
    }

    public Feedback setIs_successful(boolean is_successful) {
        this.is_successful = is_successful;
        return this;
    }
}
