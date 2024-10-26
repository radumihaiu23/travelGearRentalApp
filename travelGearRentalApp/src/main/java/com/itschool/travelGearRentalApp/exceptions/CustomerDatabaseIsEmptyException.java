package com.itschool.travelGearRentalApp.exceptions;

public class CustomerDatabaseIsEmptyException extends RuntimeException {

    public CustomerDatabaseIsEmptyException(String message) {
        super(message);
    }
}