package com.itschool.travelGearRentalApp.services;

import com.itschool.travelGearRentalApp.models.dtos.RequestCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseCustomerDTO;

import java.util.List;

public interface CustomerService {

    ResponseCustomerDTO createCustomer(RequestCustomerDTO requestCustomerDTO);

    RequestCustomerDTO updateCustomer(Long customerId, RequestCustomerDTO requestCustomerDTO);

    List<ResponseCustomerDTO> getCustomer(String firstName, String lastName, String email, String customerCode, String customerGender);

    void deleteCustomerData(Long id);

    void deleteAllCustomerData();
}