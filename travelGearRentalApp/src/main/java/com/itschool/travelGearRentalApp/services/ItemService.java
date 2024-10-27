package com.itschool.travelGearRentalApp.services;

import com.itschool.travelGearRentalApp.models.dtos.RequestItemDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseItemDTO;

import java.util.List;

public interface ItemService {

    RequestItemDTO createItem(RequestItemDTO requestItemDTO);

    List<ResponseItemDTO> getItem(String itemName, String dateOfRentedItem, String dateOfReturnedItem, String isRented, String itemCode);

    void deleteItemById(Long id);
}