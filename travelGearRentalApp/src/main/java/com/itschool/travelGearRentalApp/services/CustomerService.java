package com.itschool.travelGearRentalApp.services;

import com.itschool.travelGearRentalApp.models.dtos.PatchCustomerDTO;
import com.itschool.travelGearRentalApp.models.dtos.PostCustomerDTO;

public interface CustomerService {

    PostCustomerDTO createCustomer(PostCustomerDTO postCustomerDTO);
    PatchCustomerDTO updateCustomer(Long customerID, String firstNameUpdate, String lastNameUpdate, String emailUpdate);

}
