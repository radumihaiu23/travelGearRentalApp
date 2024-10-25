package com.itschool.travelGearRentalApp.exceptions;

public class CustomerFirstNameAlreadyExistsException extends RuntimeException {

    public CustomerFirstNameAlreadyExistsException(String message) {
        super(message);
    }
}