package com.example.EcommerceWithSpringDataJpa.exception;

public class AddressNotFoundException extends Exception {

    public AddressNotFoundException() {
        super("Address doesn't exist.");
    }
}
