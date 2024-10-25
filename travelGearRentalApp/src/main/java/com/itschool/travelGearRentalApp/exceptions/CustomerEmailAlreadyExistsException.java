package com.itschool.travelGearRentalApp.exceptions;

public class CustomerEmailAlreadyExistsException extends RuntimeException {

    public CustomerEmailAlreadyExistsException(String message) {
        super(message);
    }
}