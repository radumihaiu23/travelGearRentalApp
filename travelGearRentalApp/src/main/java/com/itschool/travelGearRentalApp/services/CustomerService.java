package com.itschool.travelGearRentalApp.services;

import com.itschool.travelGearRentalApp.models.dtos.PatchCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.PostCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseCustomerDTO;

import java.util.List;

public interface CustomerService {

    PostCustomerDTO createCustomer(PostCustomerDTO postCustomerDTO);

    PatchCustomerDTO updateCustomer(Long customerID, String firstNameUpdate, String lastNameUpdate, String emailUpdate);

    List<ResponseCustomerDTO> getCustomer(String firstName, String lastName, String email, String customerCode);


}
