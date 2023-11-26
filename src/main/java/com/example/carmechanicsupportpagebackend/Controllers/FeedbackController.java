package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Dtos.FeedbackForCreationDTO;
import com.example.carmechanicsupportpagebackend.Dtos.FeedbackForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import com.example.carmechanicsupportpagebackend.Models.Car;
import com.example.carmechanicsupportpagebackend.Models.Feedback;
import com.example.carmechanicsupportpagebackend.Models.Order;
import com.example.carmechanicsupportpagebackend.Services.FeedbackService;
import com.example.carmechanicsupportpagebackend.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {
    private final FeedbackService feedbackService;
    private final OrderService orderService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, OrderService orderService) {
        this.feedbackService = feedbackService;
        this.orderService = orderService;
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

    @PostMapping("Orders/{orderid}/Feedbacks")
    public ResponseEntity createNewFeedback(@PathVariable int orderid,@RequestBody FeedbackForCreationDTO newFeedback){
        if (orderid<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");

        Optional<Order> orderById = orderService.getOrderById(orderid);
        if (orderById.isPresent())
        {
            Feedback feedbackToAdd=new Feedback(newFeedback);
            feedbackToAdd.setRelatedOrder(orderById.get());

            feedbackService.addNewFeedback(feedbackToAdd);

            return new ResponseEntity<>(feedbackService.getFeedbackByComment(newFeedback.comment()).get(),HttpStatus.CREATED);
        }
        else throw new EntryNotFoundException("No such Order!");
    }

    @PatchMapping("/Feedbacks/{id}")
    public ResponseEntity updateFeedback(@PathVariable int id, @RequestBody FeedbackForUpdateDTO feedbackNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        feedbackService.updateFeedback(id, feedbackNewData);

        return new ResponseEntity(feedbackService.getFeedbackById(id).get(),HttpStatus.OK);

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
