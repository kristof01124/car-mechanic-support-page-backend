package com.example.carmechanicsupportpagebackend.Services.Impl;

import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import com.example.carmechanicsupportpagebackend.Dtos.UserDAO;
import com.example.carmechanicsupportpagebackend.Services.UserServices;

import java.sql.Date;

/**
 * TODO: Danka, ez a te részed. Ha ezt az osztályt sikerül megcsinálni, utána a többi táblánál csak copy-paste
 *
 * <p>This will be the implementation of the UserRepository interface, handled by the Spring IoC system.
 */
public class UserServiceImpl implements UserServices {
    @Override
    public UserDAO getUserById(int id) throws EntryNotFoundException, MalformedRequestException {
        return null;
    }

    @Override
    public boolean createNewUser(String first_name, String last_name, Date date_of_birth, String phone_number, String email) {
        return false;
    }

    @Override
    public void updateUser(int user_id, String first_name, String last_name, Date date_of_birth, String phone_number, String email) throws EntryNotFoundException, MalformedRequestException {

    }

    @Override
    public boolean deleteUser(int user_id) throws EntryNotFoundException, MalformedRequestException {
        return false;
    }

    @Override
    public boolean saveChanges() {
        return false;
    }
}