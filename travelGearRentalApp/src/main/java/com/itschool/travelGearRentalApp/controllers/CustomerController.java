package com.itschool.travelGearRentalApp.controllers;

import com.itschool.travelGearRentalApp.models.dtos.RequestCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseCustomerDTO;
import com.itschool.travelGearRentalApp.services.CustomerService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ResponseCustomerDTO> createCustomer(@Valid @RequestBody RequestCustomerDTO requestCustomerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(requestCustomerDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseCustomerDTO>> getCustomer(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "customerCode", required = false) String customerCode,
            @RequestParam(value = "customerGender", required = false) String customerGender) {
        return ResponseEntity.ok(customerService.getCustomer(firstName, lastName, email, customerCode, customerGender));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseCustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody RequestCustomerDTO requestCustomerDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(id, requestCustomerDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCustomerData(@PathVariable Long id) {
        customerService.deleteCustomerData(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllCustomerData() {
        customerService.deleteAllCustomerData();
        return ResponseEntity.noContent().build();
    }
}