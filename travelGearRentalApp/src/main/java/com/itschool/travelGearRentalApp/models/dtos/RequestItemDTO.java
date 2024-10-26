package com.itschool.travelGearRentalApp.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RequestItemDTO {

    private Long ID;
    @NotBlank(message = "itemName must not be blank")
    @NotNull(message = "itemName must not be null")
    private String itemName;
    private LocalDateTime dateOfRentedItem;
    private LocalDateTime dateOfReturnedItem;
    private String isRented;
    private UUID itemCode;
}