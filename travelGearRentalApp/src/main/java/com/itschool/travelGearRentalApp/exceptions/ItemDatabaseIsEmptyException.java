package com.itschool.travelGearRentalApp.exceptions;

public class ItemDatabaseIsEmptyException extends RuntimeException {
    public ItemDatabaseIsEmptyException(String message) {
        super(message);
    }
}