package com.itschool.travelGearRentalApp.exceptions;

public class ItemNameAlreadyExistsException extends RuntimeException {

    public ItemNameAlreadyExistsException(String message) {
        super(message);
    }
}
