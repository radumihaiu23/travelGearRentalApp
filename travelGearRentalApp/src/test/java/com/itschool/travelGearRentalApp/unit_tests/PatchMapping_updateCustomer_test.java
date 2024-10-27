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
public class PatchMapping_updateCustomer_test {

    @InjectMocks
    private CustomerController customerController;
    @Mock
    private CustomerService customerService;

    @Test
    void testCreateCustomer() {
        //given
        Long pathVariable = 23L;

        RequestCustomerDTO requestCustomerDTO = new RequestCustomerDTO();
        requestCustomerDTO.setId(pathVariable);
        requestCustomerDTO.setFirstName("patch");
        requestCustomerDTO.setLastName("test");
        requestCustomerDTO.setEmail("patchtest@email.com");
        UUID uuid = UUID.randomUUID();
        requestCustomerDTO.setCustomerCode(uuid);
        System.out.println("patch test uuid is:" + uuid);
        requestCustomerDTO.setCustomerGender("M");

        RequestCustomerDTO expectedCustomerDTO = new RequestCustomerDTO();
        expectedCustomerDTO.setId(pathVariable);
        expectedCustomerDTO.setFirstName("test");
        expectedCustomerDTO.setLastName("test");
        expectedCustomerDTO.setEmail("test@email.com");
        expectedCustomerDTO.setCustomerCode(uuid);
        System.out.println("test uuid is:" + uuid);
        expectedCustomerDTO.setCustomerGender("M");

        when(customerService.updateCustomer(pathVariable,requestCustomerDTO)).thenReturn(expectedCustomerDTO);

        //when
        ResponseEntity<RequestCustomerDTO> response = customerController.updateCustomer(pathVariable, requestCustomerDTO);

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCustomerDTO, response.getBody());
    }
}