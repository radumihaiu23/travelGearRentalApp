package com.itschool.travelGearRentalApp.controllers;

import com.itschool.travelGearRentalApp.models.dtos.PatchCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.PostCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseCustomerDTO;
import com.itschool.travelGearRentalApp.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<PostCustomerDTO> createCustomer(@RequestBody PostCustomerDTO postCustomerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(postCustomerDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatchCustomerDTO> updateCustomer(@PathVariable Long id,
                                                           @RequestBody
                                                           PatchCustomerDTO firstName,
                                                           PatchCustomerDTO lastName,
                                                           PatchCustomerDTO email) {
        return ResponseEntity.ok(customerService.updateCustomer(
                id,
                firstName.getFirstName(),
                lastName.getLastName(),
                email.getEmail()));
    }

    @GetMapping
    public ResponseEntity<List<ResponseCustomerDTO>> getCustomer(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "customerGender", required = false) String customerGender) {
        return ResponseEntity.ok(customerService.getCustomer(firstName, lastName, email, customerGender));
    }
}