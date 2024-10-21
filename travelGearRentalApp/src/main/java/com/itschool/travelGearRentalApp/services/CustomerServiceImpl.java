package com.itschool.travelGearRentalApp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        return null;
    }

}