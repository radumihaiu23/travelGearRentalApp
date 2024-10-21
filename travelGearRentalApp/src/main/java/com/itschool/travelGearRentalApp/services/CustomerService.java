package com.itschool.travelGearRentalApp.services;

import com.itschool.travelGearRentalApp.models.dtos.PostCustomerDTO;

public interface CustomerService {

    PostCustomerDTO createCustomer(PostCustomerDTO postCustomerDTO);
}
