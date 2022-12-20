package com.example.ecommercewithspringdatajpa.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer id) {
        super("Could not find user with id " + id);
    }

    public UserNotFoundException(String email) {
        super("Could not find user with email " + email);
    }
}
