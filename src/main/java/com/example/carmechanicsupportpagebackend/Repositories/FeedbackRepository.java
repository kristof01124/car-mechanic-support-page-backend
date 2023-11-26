package com.example.carmechanicsupportpagebackend.Repositories;

import com.example.carmechanicsupportpagebackend.Models.Feedback;
import com.example.carmechanicsupportpagebackend.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Query("SELECT f FROM Feedback f WHERE f.comment=?1")
    Optional<Feedback> findFeedbackByComment(String comment);
}
