package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Dtos.*;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {
    //Replace these two variables when we have an actual DB
    List<FeedbackDAO> shittyMockDB = new ArrayList<>();
    int entryIndexCounter=0;

    @GetMapping("/Feedbacks")
    public ResponseEntity getFeedbacks(){
        return new ResponseEntity(shittyMockDB, HttpStatus.OK);
    }
    @GetMapping("/Feedbacks/{id}")
    public ResponseEntity getFeedbackById(@PathVariable int id){
        if (id<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");
        for (FeedbackDAO feedback : shittyMockDB){
            if (feedback.getFeedback_id() == id){
                return new ResponseEntity<>(feedback, HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such feedback!");
    }

    @PostMapping("/Feedbacks")
    public ResponseEntity createNewFeedback(@RequestBody FeedbackForCreationDTO newFeedback){
        entryIndexCounter++;
        FeedbackDAO feedbackToAdd = new FeedbackDAO(entryIndexCounter, newFeedback);

        shittyMockDB.add(feedbackToAdd);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/Feedbacks/{id}")
    public ResponseEntity updateFeedback(@PathVariable int id, @RequestBody FeedbackForUpdateDTO feedbackNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        for (FeedbackDAO feedback : shittyMockDB){
            if (feedback.getFeedback_id() == id){
                feedback.setValuesToOtherFeedbackDTO(feedbackNewData);
                return new ResponseEntity<>(feedback, HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such feedback!");

    }

    @DeleteMapping("/Feedbacks/{id}")
    public ResponseEntity deleteFeedback(@PathVariable int id){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        for (FeedbackDAO feedback : shittyMockDB){
            if (feedback.getFeedback_id() == id){
                shittyMockDB.remove(feedback);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such feedback!");
    }
}
