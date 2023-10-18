package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import com.example.carmechanicsupportpagebackend.dto.UserDAO;
import com.example.carmechanicsupportpagebackend.dto.UserForCreationDTO;
import com.example.carmechanicsupportpagebackend.Models.UserRoles;
import com.example.carmechanicsupportpagebackend.dto.UserForUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TODO: Megcsinálni az egész osztályt amint van DB
@RestController
public class UserController {

    //Replace these two variables when we have an actual DB
    List<UserDAO> shittyMockDB = new ArrayList<>();
    int entryIndexCounter=0;

    @GetMapping("/init")
    public UserDAO initialize(){
        entryIndexCounter++;
        UserDAO user=new UserDAO(entryIndexCounter,"Elek", "Vicc",
                Date.valueOf(LocalDate.now()),"+36306614291",
                "martinsandor707@gmail.com",UserRoles.ADMIN.name());

        shittyMockDB.add(user);
        return user;
    }

    @GetMapping("/Users/{id}")
    public ResponseEntity getUserById(@PathVariable int id){
        if (id<1)
            throw new MalformedRequestException("An ID has to be a positive integer!");
        for (UserDAO user : shittyMockDB){
            if (user.getUser_id() == id){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such user!");
    }

    @PostMapping("/Users")
    public ResponseEntity createNewUser(@RequestBody UserForCreationDTO newUser){
        entryIndexCounter++;
        UserDAO userToAdd = new UserDAO(entryIndexCounter, newUser);

        shittyMockDB.add(userToAdd);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/Users/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody UserForUpdateDTO userNewData){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        for (UserDAO user : shittyMockDB){
            if (user.getUser_id() == id){
                user.setValuesToOtherUserDTO(userNewData);
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such entry!");

    }

    @DeleteMapping("/Users/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        if (id < 1)
            throw new MalformedRequestException("The ID has to be a positive integer!");
        for (UserDAO user : shittyMockDB){
            if (user.getUser_id() == id){
                shittyMockDB.remove(user);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        throw new EntryNotFoundException("No such entry!");
    }
}
