package com.itschool.travelGearRentalApp.controllers;

import com.itschool.travelGearRentalApp.models.dtos.PostCustomerDTO;
import com.itschool.travelGearRentalApp.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/customers")
    public ResponseEntity<PostCustomerDTO> createCustomer(@RequestBody PostCustomerDTO postCustomerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(postCustomerDTO));
    }
}