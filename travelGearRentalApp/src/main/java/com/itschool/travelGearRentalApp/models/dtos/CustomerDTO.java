package com.itschool.travelGearRentalApp.models.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.UUID;

@Data
public class CustomerDTO {

    private Long ID;
    private String firstName;
    private String lastName;
    private String email;
    private UUID customerCode;
    private String customerGender;
}