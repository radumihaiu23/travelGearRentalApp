package com.itschool.travelGearRentalApp.exceptions;

public class CustomerLastNameAlreadyExistsException extends RuntimeException {

    public CustomerLastNameAlreadyExistsException(String message) {
        super(message);
    }
}
