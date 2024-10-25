package com.itschool.travelGearRentalApp.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data                           //generates getters and setters
@Entity                         // class representation as a table stored in database
@Table(name = "customers")      // give custom name to table in database
public class Customer {

    @Id                                                  // marks a field of an entity as the primary key in the database table
    @GeneratedValue( strategy = GenerationType.IDENTITY) // the primary key will be automatically created by the database
    private Long id;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "customer_Code")
    private UUID customerCode;

    @Column(name = "customer_Gender")
    private String customerGender;
}