package com.itschool.travelGearRentalApp.unit_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.travelGearRentalApp.exceptions.CustomerEmailAlreadyExistsException;
import com.itschool.travelGearRentalApp.models.dtos.RequestCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseCustomerDTO;
import com.itschool.travelGearRentalApp.models.entities.Customer;
import com.itschool.travelGearRentalApp.repositories.CustomerRepository;
import com.itschool.travelGearRentalApp.services.CustomerService;
import com.itschool.travelGearRentalApp.services.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private RequestCustomerDTO requestCustomerDTO;
    @InjectMocks
    private CustomerServiceImpl customerService;




    @Test
    void testCreateCustomer() {
            //given
            //when
            //then

    }
}