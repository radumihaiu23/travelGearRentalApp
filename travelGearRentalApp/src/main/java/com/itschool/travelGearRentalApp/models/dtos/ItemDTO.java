package com.itschool.travelGearRentalApp.models.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ItemDTO {

    private Long ID;
    private String itemName;
    private LocalDateTime dateOfRentedItem;
    private LocalDateTime dateOfReturnedItem;
    private Boolean isRented;
    private UUID itemCode;
}