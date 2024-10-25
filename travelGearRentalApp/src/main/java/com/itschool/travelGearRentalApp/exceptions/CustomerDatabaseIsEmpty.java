package com.itschool.travelGearRentalApp.exceptions;

public class CustomerDatabaseIsEmpty extends RuntimeException{

    public CustomerDatabaseIsEmpty(String message) {
        super(message);
    }
}
