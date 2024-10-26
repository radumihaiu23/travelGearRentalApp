package com.itschool.travelGearRentalApp.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RequestItemDTO {

    private Long ID;
    @NotNull(message = "itemName must be not null")
    private String itemName;
    private LocalDateTime dateOfRentedItem;
    private LocalDateTime dateOfReturnedItem;
    private Boolean isRented;
    private UUID itemCode;
}