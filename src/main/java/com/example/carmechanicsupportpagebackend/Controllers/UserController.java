package com.example.carmechanicsupportpagebackend.Controllers;

import com.example.carmechanicsupportpagebackend.Models.UserDAO;
import com.example.carmechanicsupportpagebackend.Models.UserForCreationDTO;
import com.example.carmechanicsupportpagebackend.Models.UserForUpdateDTO;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

//TODO: Megcsinálni az egész osztályt amint van DB
@RestController
public class UserController {

    @GetMapping("/Users/{id}")
    public UserDAO getUserById(@PathVariable int id){
        return new UserDAO(id, "Elek", "Vicc", Date.valueOf(LocalDate.now()),
                "+36306614291", "martinsandor707@gmail.com");
    }

    @PostMapping("/Users")
    public UserDAO createNewUser(@RequestBody UserForCreationDTO newUser){

        return new UserDAO(0, "Elek", "Vicc", Date.valueOf(LocalDate.now()),
                "+36306614291", "martinsandor707@gmail.com");
    }

    @PatchMapping("/Users/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserForUpdateDTO userNewData){

    }

    @DeleteMapping("/Users/{id}")
    public boolean deleteUser(@PathVariable int id){
        return false;
    }
}
