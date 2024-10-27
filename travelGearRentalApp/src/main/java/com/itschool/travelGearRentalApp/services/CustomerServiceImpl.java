package com.itschool.travelGearRentalApp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.travelGearRentalApp.exceptions.*;
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
import java.util.UUID;

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
    public ResponseCustomerDTO createCustomer(RequestCustomerDTO requestCustomerDTO) {
        validateCustomerEmail(requestCustomerDTO);
        validateCustomerFirstName(requestCustomerDTO);
        validateCustomerLastName(requestCustomerDTO);

        Customer customerEntity = objectMapper.convertValue(requestCustomerDTO, Customer.class);
        customerEntity.setCustomerCode(UUID.randomUUID());
        Customer customerEntityResponse = customerRepository.save(customerEntity);
        log.info("Customer id: {} was saved in database", customerEntityResponse.getId());

        return objectMapper.convertValue(customerEntityResponse, ResponseCustomerDTO.class);
    }

    @Override
    public ResponseCustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody RequestCustomerDTO requestCustomerDTO) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found"));

        customer.setFirstName(requestCustomerDTO.getFirstName());
        customer.setLastName(requestCustomerDTO.getLastName());
        customer.setEmail(requestCustomerDTO.getEmail());
        customer.setCustomerGender(requestCustomerDTO.getCustomerGender());
        Customer updatedCustomer = customerRepository.save(customer);
        log.info("Customer id: {} was updated", updatedCustomer.getId());

        return objectMapper.convertValue(updatedCustomer, ResponseCustomerDTO.class);
    }

    @Override
    public List<ResponseCustomerDTO> getCustomer(String firstName, String lastName, String email, String customerCode, String customerGender) {
        Specification<Customer> spec = Specification
                .where(CustomerSpecification.firstNameContains(firstName))
                .and(CustomerSpecification.lastNameContains(lastName))
                .and(CustomerSpecification.emailContains(email))
                .and(CustomerSpecification.customerCodeContains(customerCode))
                .and(CustomerSpecification.customerGenderContains(customerGender));

        List<Customer> filteredCustomers = customerRepository.findAll(spec);
        log.info("{} customers found", filteredCustomers.size());

        if (filteredCustomers.isEmpty()) {
            throw new CustomerDatabaseIsEmptyException("Customer database is empty");
        }

        return filteredCustomers.stream()
                .map(customer -> objectMapper.convertValue(customer, ResponseCustomerDTO.class))
                .toList();

    }

    @Override
    public void deleteCustomerData(Long customerId) {
        customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer id: " + customerId + " cannot be found in database"));
        customerRepository.deleteById(customerId);
        log.info("All customer id: {} data was deleted", customerId);
    }

    @Override
    public void deleteAllCustomerData() {
        customerRepository.deleteAll();
        log.info("Customer database is empty");

    }

    public void validateCustomerEmail(RequestCustomerDTO requestCustomerDTO) {
        Customer customer = customerRepository.findByEmail(requestCustomerDTO.getEmail());
        if (customer != null) {
            throw new CustomerEmailAlreadyExistsException("Customer email already exists in database");
        }
    }

    public void validateCustomerFirstName(RequestCustomerDTO requestCustomerDTO) {
        Customer customer = customerRepository.findByFirstName(requestCustomerDTO.getFirstName());
        if (customer != null) {
            throw new CustomerFirstNameAlreadyExistsException("Customer firstName already exists in database");
        }
    }

    public void validateCustomerLastName(RequestCustomerDTO requestCustomerDTO) {
        Customer customer = customerRepository.findByLastName(requestCustomerDTO.getLastName());
        if (customer != null) {
            throw new CustomerLastNameAlreadyExistsException("Customer lastName already exists in database");
        }
    }
}