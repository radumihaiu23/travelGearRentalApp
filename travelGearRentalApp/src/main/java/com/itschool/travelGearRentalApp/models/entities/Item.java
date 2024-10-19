package com.itschool.travelGearRentalApp.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "date_of_rented_item")
    private LocalDateTime dateOfRentedItem;

    @Column(name = "date_of_returned_item")
    private LocalDateTime dateOfReturnedItem;

    @Column(name = "is_rented")
    private Boolean isRented;

    @Column(name = "item_code")
    private UUID itemCode;
}