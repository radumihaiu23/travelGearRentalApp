package com.itschool.travelGearRentalApp.unit_tests;

import com.itschool.travelGearRentalApp.controllers.CustomerController;
import com.itschool.travelGearRentalApp.models.dtos.RequestCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseCustomerDTO;
import com.itschool.travelGearRentalApp.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostMapping_createCustomer_test {

    @InjectMocks
    private CustomerController customerController;
    @Mock
    private CustomerService customerService;

    @Test
    void testCreateCustomer() {
        //given
        RequestCustomerDTO requestCustomerDTO = new RequestCustomerDTO();
        requestCustomerDTO.setId(1L);
        requestCustomerDTO.setFirstName("test");
        requestCustomerDTO.setLastName("test");
        requestCustomerDTO.setEmail("test@email.com");
        UUID uuid = UUID.randomUUID();
        requestCustomerDTO.setCustomerCode(uuid);
        System.out.println("test uuid is:" + uuid);
        requestCustomerDTO.setCustomerGender("M");

        ResponseCustomerDTO expectedCustomerDTO = new ResponseCustomerDTO();
        expectedCustomerDTO.setId(1L);
        expectedCustomerDTO.setFirstName("test");
        expectedCustomerDTO.setLastName("test");
        expectedCustomerDTO.setEmail("test@email.com");
        expectedCustomerDTO.setCustomerCode(uuid);
        System.out.println("test uuid is:" + uuid);
        expectedCustomerDTO.setCustomerGender("M");

        when(customerService.createCustomer(requestCustomerDTO)).thenReturn(expectedCustomerDTO);

        //when
        ResponseEntity<ResponseCustomerDTO> response = customerController.createCustomer(requestCustomerDTO);

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCustomerDTO, response.getBody());
    }
}