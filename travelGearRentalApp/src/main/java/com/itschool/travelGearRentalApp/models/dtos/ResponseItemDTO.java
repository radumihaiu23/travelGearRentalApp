package com.itschool.travelGearRentalApp.models.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ResponseItemDTO {

    private Long ID;
    private String itemName;
    private LocalDateTime dateOfRentedItem;
    private LocalDateTime dateOfReturnedItem;
    private String isRented;
    private UUID itemCode;
}