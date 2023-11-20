package com.example.carmechanicsupportpagebackend.Services;

import com.example.carmechanicsupportpagebackend.Dtos.FeedbackForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Dtos.OrderForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Models.Feedback;
import com.example.carmechanicsupportpagebackend.Models.Order;
import com.example.carmechanicsupportpagebackend.Repositories.FeedbackRepository;
import com.example.carmechanicsupportpagebackend.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Optional<Feedback> getOrderById(int id){
        return feedbackRepository.findById(id);
    }

    public List<Feedback> getAllFeedbacks(){
        return feedbackRepository.findAll();
    }

    public void addNewOrder(Feedback feedback){
        //No need to check if the same entry already exists, because many cars can have the same problem
        feedbackRepository.save(feedback);
    }

    public boolean deleteFeedback(int feedbackId){
        Optional<Feedback> feedback = feedbackRepository.findById(feedbackId);

        if (feedback.isPresent()){
            feedbackRepository.deleteById(feedbackId);
            return true;
        }
        else return false;
    }

    //I hate Java for forcing me to use such an ugly solution, jesus christ
    @Transactional
    public void updateOrder(int feedbackId, FeedbackForUpdateDTO newValues){
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new EntryNotFoundException("No such Feedback!"));

        if (newValues.title() != null
                && !newValues.title().isEmpty()){
            feedback.setTitle(newValues.title());
        }
        if (newValues.start_time() != null){
            feedback.setStart_time(newValues.start_time());
        }
        if (newValues.end_time() != null){
            feedback.setEnd_time(newValues.end_time()   );
        }
        if (newValues.comment() != null
                && !newValues.comment().isEmpty()){
            feedback.setComment(newValues.comment());
        }

        feedback.setIs_successful(newValues.isSuccessful());


    }
}
