package com.example.carmechanicsupportpagebackend.Services;


import com.example.carmechanicsupportpagebackend.Exceptions.EntryNotFoundException;
import com.example.carmechanicsupportpagebackend.Exceptions.MalformedRequestException;
import com.example.carmechanicsupportpagebackend.Models.UserDAO;

import java.sql.Date;

/**
 *  The interface used to interact with the Users table of the database.
 *  <p>
 *  If we were to do this properly, we would need to implement parallel programming
 *  in almost all methods so the database doesn't shit itself if it gets more than a couple
 *  requests in quick succession. I really hope Spring's voodoo handles this somehow,
 *  because I sure don't have experience in parallel programming in Java.
 *
 * TODO: Consider implementing a creation and update DTO... or is the DAO class supposed to handle that conceptually?
 *
 * @See Models.UserDAO
 */
public interface UserRepository {

    /**
     * GET request for a singular User
     * @param id
     * @return The User with the corresponding ID
     * @throws EntryNotFoundException
     * @throws MalformedRequestException
     */
    UserDAO getUserById(int id) throws EntryNotFoundException, MalformedRequestException;

    /**
     * POST request for a new User.
     * The user_id was purposefully not made a parameter, because the ID should be
     * automatically generated by the database
     * @param first_name
     * @param last_name
     * @param date_of_birth
     * @param phone_number
     * @param email
     * @return true if a new User has been successfully created, false otherwise.
     */
    boolean createNewUser(String first_name, String last_name, Date date_of_birth,
                          String phone_number, String email);


    /**
     * PATCH request for an existing user.
     * Since PATCH can be a partial update, every input parameter is optional except the user_id.
     * Optionality will be handled in the corresponding controller class
     * @param user_id
     * @param first_name
     * @param last_name
     * @param date_of_birth
     * @param phone_number
     * @param email
     * @throws EntryNotFoundException
     * @throws MalformedRequestException
     */
    void updateUser(int user_id, String first_name, String last_name, Date date_of_birth,
                    String phone_number, String email) throws EntryNotFoundException, MalformedRequestException;

    /**
     * DELETE request for an existing user
     * @param user_id
     * @return
     * @throws EntryNotFoundException
     * @throws MalformedRequestException
     */
    boolean deleteUser(int user_id) throws EntryNotFoundException, MalformedRequestException;

    /**
     * Method to make any changes up to this point persistent, not just in-memory
     * @return true if successful, false otherwise
     */
    boolean saveChanges();
}