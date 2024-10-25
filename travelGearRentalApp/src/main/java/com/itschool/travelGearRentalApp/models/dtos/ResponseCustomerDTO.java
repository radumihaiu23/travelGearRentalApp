package com.itschool.travelGearRentalApp.models.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ResponseCustomerDTO {

    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private UUID customerCode;
    private String customerGender;
    }
