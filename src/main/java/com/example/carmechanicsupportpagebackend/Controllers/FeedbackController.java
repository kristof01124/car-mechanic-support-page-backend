package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Dtos.FeedbackForCreationDTO;
import com.example.carmechanicsupportpagebackend.Dtos.FeedbackForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import com.example.carmechanicsupportpagebackend.Models.Feedback;
import com.example.carmechanicsupportpagebackend.Services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/Feedbacks")
    public ResponseEntity getAllFeedbacks(){
        return new ResponseEntity<>(feedbackService.getAllFeedbacks(), HttpStatus.OK);
    }
    @GetMapping("/Feedbacks/{id}")
    public ResponseEntity getFeedbackById(@PathVariable int id){
        if (id<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");

        Optional<Feedback> feedbackById = feedbackService.getFeedbackById(id);
        if (feedbackById.isPresent())
            return new ResponseEntity<>(feedbackById.get(), HttpStatus.OK);
        else
            throw new EntryNotFoundException("No such feedback!");
    }

    @PostMapping("/Feedbacks")
    public ResponseEntity createNewFeedback(@RequestBody FeedbackForCreationDTO newFeedback){
        Feedback FeedbackToAdd=new Feedback(newFeedback);

        feedbackService.addNewFeedback(FeedbackToAdd);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/Feedbacks/{id}")
    public ResponseEntity updateFeedback(@PathVariable int id, @RequestBody FeedbackForUpdateDTO feedbackNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        feedbackService.updateFeedback(id, feedbackNewData);

        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("/Feedbacks/{id}")
    public ResponseEntity deleteFeedback(@PathVariable int id){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        if (feedbackService.deleteFeedback(id))
            return new ResponseEntity(HttpStatus.OK);
        else
            throw new EntryNotFoundException("No such feedback!");
    }
}
