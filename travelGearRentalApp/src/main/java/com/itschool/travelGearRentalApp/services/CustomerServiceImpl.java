package com.itschool.travelGearRentalApp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.travelGearRentalApp.exceptions.CustomerNotFoundException;
import com.itschool.travelGearRentalApp.models.dtos.RequestCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseCustomerDTO;
import com.itschool.travelGearRentalApp.models.entities.Customer;
import com.itschool.travelGearRentalApp.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    public RequestCustomerDTO createCustomer(RequestCustomerDTO requestCustomerDTO) {
        Customer customerEntity = objectMapper.convertValue(requestCustomerDTO, Customer.class);
        Customer customerEntityResponse = customerRepository.save(customerEntity);
        log.info("Customer with id {} was saved in database", customerEntityResponse.getId());
        return objectMapper.convertValue(customerEntityResponse, RequestCustomerDTO.class);
    }

    @Override
    public RequestCustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody RequestCustomerDTO requestCustomerDTO) {
        Customer customer= customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found"));

        customer.setFirstName(requestCustomerDTO.getFirstName());
        customer.setLastName(requestCustomerDTO.getLastName());
        customer.setEmail(requestCustomerDTO.getEmail());
        customer.setCustomerGender(requestCustomerDTO.getCustomerGender());

        Customer updatedCustomer = customerRepository.save(customer);
        log.info("Customer with id {} was updated",updatedCustomer.getId());
        return objectMapper.convertValue(updatedCustomer, RequestCustomerDTO.class);
    }

    @Override
    public List<ResponseCustomerDTO> getCustomer(String firstName, String lastName, String email, String customerGender) {
        Specification<Customer> spec = Specification
                .where(CustomerSpecification.firstNameContains(firstName))
                .and(CustomerSpecification.lastNameContains(lastName))
                .and(CustomerSpecification.emailContains(email))
                .and(CustomerSpecification.customerGenderContains(customerGender));

        List<Customer> filteredCustomers = customerRepository.findAll(spec);
        log.info("{} customers were found", filteredCustomers.size());

        return filteredCustomers.stream()
                .map(customer -> objectMapper.convertValue(customer, ResponseCustomerDTO.class))
                .toList();
    }
}