package com.itschool.travelGearRentalApp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.travelGearRentalApp.exceptions.CustomerNotFoundException;
import com.itschool.travelGearRentalApp.models.dtos.PatchCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.PostCustomerDTO;
import com.itschool.travelGearRentalApp.models.entities.Customer;
import com.itschool.travelGearRentalApp.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final ObjectMapper objectMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(ObjectMapper objectMapper, CustomerRepository customerRepository) {
        this.objectMapper = objectMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public PostCustomerDTO createCustomer(PostCustomerDTO postCustomerDTO) {
        Customer customerEntity = objectMapper.convertValue(postCustomerDTO, Customer.class);
        Customer customerEntityResponse = customerRepository.save(customerEntity);
        log.info(" Customer with id {} was saved in database ", customerEntityResponse.getID());
        return objectMapper.convertValue(customerEntityResponse, PostCustomerDTO.class);
    }

    @Override
    public PatchCustomerDTO updateCustomer(Long customerId, String firstNameUpdate, String lastNameUpdate, String emailUpdate) {
        Customer customerEntityUpdate = customerRepository.findById(customerId).orElseThrow( () -> new CustomerNotFoundException("Customer with ID " + customerId + " not found"));

        customerEntityUpdate.setFirstName(firstNameUpdate);
        customerEntityUpdate.setLastName(lastNameUpdate);  // DOES NOT WORK
        customerEntityUpdate.setEmail(emailUpdate);        //DOES NOT WORK
        Customer updatedCustomer = customerRepository.save(customerEntityUpdate);

        log.info("Updated details for customer id { }", updatedCustomer.getID());
        return objectMapper.convertValue(updatedCustomer, PatchCustomerDTO.class);
    }
}