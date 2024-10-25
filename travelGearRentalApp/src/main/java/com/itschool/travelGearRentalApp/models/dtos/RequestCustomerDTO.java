package com.itschool.travelGearRentalApp.models.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestCustomerDTO {

    private Long Id;
    @NotNull(message = "firstName must be not blank")
    @NotBlank(message = "firstName must be not blank")
    private String firstName;
    @NotNull(message = "lastName must be not blank")
    @NotBlank(message = "lastName must be not blank")
    private String lastName;
    private String email;
    private UUID customerCode;
    private String customerGender;
}