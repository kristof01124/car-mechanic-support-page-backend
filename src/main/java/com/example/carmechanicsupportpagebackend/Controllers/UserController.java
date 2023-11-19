package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import com.example.carmechanicsupportpagebackend.Dtos.UserDAO;
import com.example.carmechanicsupportpagebackend.Dtos.UserForCreationDTO;
import com.example.carmechanicsupportpagebackend.Models.User;
import com.example.carmechanicsupportpagebackend.Models.UserRoles;
import com.example.carmechanicsupportpagebackend.Dtos.UserForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Repositories.UserRepository;
import com.example.carmechanicsupportpagebackend.Services.CarService;
import com.example.carmechanicsupportpagebackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//TODO: Megcsinálni az egész osztályt amint van DB
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/Users")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/Users/{id}")
    public ResponseEntity getUserById(@PathVariable int id){
        if (id<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");

        Optional<User> userById = userService.getUserById(id);
        if (userById.isPresent())
            return new ResponseEntity<>(userById.get(), HttpStatus.OK);
        else
            throw new EntryNotFoundException("No such user!");
    }

    @PostMapping("/Users")
    public ResponseEntity createNewUser(@RequestBody UserForCreationDTO newUser){
        User userToAdd=new User(newUser);

        userService.addNewUser(userToAdd);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/Users/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody UserForUpdateDTO userNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        userService.updateUser(id, userNewData);

        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("/Users/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        if (userService.deleteUser(id))
            return new ResponseEntity(HttpStatus.OK);
        else
            throw new EntryNotFoundException("No such user!");
    }
}
