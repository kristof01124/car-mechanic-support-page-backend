package com.example.carmechanicsupportpagebackend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception used when 400BadRequest occurs in any request directed at the database,
 * such as when a negative number is provided as an ID.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MalformedRequestException extends RuntimeException{
    public MalformedRequestException(String message){
        super(message);
    }
}
