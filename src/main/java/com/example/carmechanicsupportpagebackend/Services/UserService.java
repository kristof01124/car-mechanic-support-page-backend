package com.example.carmechanicsupportpagebackend.Services;

import com.example.carmechanicsupportpagebackend.Dtos.UserForCreationDTO;
import com.example.carmechanicsupportpagebackend.Dtos.UserForUpdateDTO;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryAlreadyExistsException;
import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Models.User;
import com.example.carmechanicsupportpagebackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user){
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail_address());
        if (userOptional.isPresent()){
            throw new EntryAlreadyExistsException("An account already exists with this email!");
        }
        userRepository.save(user);
    }

    public boolean deleteUser(int userId){
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        else return false;
    }

    //I hate Java for forcing me to use such an ugly solution, jesus christ
    @Transactional
    public void updateUser(int userId, UserForUpdateDTO newValues){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntryNotFoundException("No such User!"));
        if (newValues.first_name() != null
        && newValues.first_name().length() > 0){
            user.setFirst_name(newValues.first_name());
        }
        if (newValues.last_name() != null
                && newValues.last_name().length() > 0){
            user.setLast_name(newValues.last_name());
        }
        if (newValues.date_of_birth() !=null){
            user.setDate_of_birth(newValues.date_of_birth());
        }
        if (newValues.phone_number() != null
                && newValues.phone_number().length() > 0){
            user.setPhone_nuber(newValues.phone_number());
        }
        if (newValues.email_address() != null
                && newValues.email_address().length() > 0
                && !userRepository.findUserByEmail(newValues.email_address()).isPresent()) {
            user.setEmail_address(newValues.email_address());
        }
        if (newValues.password() != null
                && newValues.password().length() > 0){
            user.setPassword(newValues.password());
        }
        if (newValues.user_role() != null
                && newValues.user_role().length() > 0){
            user.setUser_role(newValues.user_role());
        }

    }
}
