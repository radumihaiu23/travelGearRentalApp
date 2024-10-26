package com.itschool.travelGearRentalApp.unit_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.travelGearRentalApp.models.dtos.RequestCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseCustomerDTO;
import com.itschool.travelGearRentalApp.models.entities.Customer;
import com.itschool.travelGearRentalApp.repositories.CustomerRepository;
import com.itschool.travelGearRentalApp.services.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void testCreateCustomer() {
        //given
        RequestCustomerDTO requestCustomerDTO = new RequestCustomerDTO();
        requestCustomerDTO.setFirstName("testFirstName");
        requestCustomerDTO.setLastName("testLastName");
        requestCustomerDTO.setEmail("test@email.com");
        requestCustomerDTO.setCustomerGender("test");

        ResponseCustomerDTO responseCustomerDTO = new ResponseCustomerDTO();
        responseCustomerDTO.setFirstName("testFirstName");
        responseCustomerDTO.setLastName("testLastName");
        responseCustomerDTO.setEmail("test@email.com");
        responseCustomerDTO.setCustomerGender("test");

        Customer customerEntity = new Customer();
        customerEntity.setFirstName("testFirstName");
        customerEntity.setLastName("testLastName");
        customerEntity.setEmail("test@email.com");
        customerEntity.setCustomerGender("test");

        Customer savedCustomerResponse = new Customer();
        savedCustomerResponse.setFirstName("testFirstName");
        savedCustomerResponse.setLastName("testLastName");
        savedCustomerResponse.setEmail("test@email.com");
        savedCustomerResponse.setCustomerGender("test");

        when(objectMapper.convertValue(requestCustomerDTO, Customer.class)).thenReturn(customerEntity);
        when(customerRepository.save(customerEntity)).thenReturn((customerEntity));
        when(objectMapper.convertValue(savedCustomerResponse,ResponseCustomerDTO.class)).thenReturn(responseCustomerDTO);

        //when
        ResponseCustomerDTO savedCustomerDTO = customerService.createCustomer(requestCustomerDTO);

        //then
        assertEquals(requestCustomerDTO.getFirstName(), savedCustomerDTO.getFirstName());
    }
}