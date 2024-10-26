package com.itschool.travelGearRentalApp.controllers;

import com.itschool.travelGearRentalApp.models.dtos.RequestItemDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseItemDTO;
import com.itschool.travelGearRentalApp.services.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/items")
@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<RequestItemDTO> createItem(@Valid @RequestBody RequestItemDTO requestItemDTO) {
        return ResponseEntity.ok(itemService.createItem(requestItemDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseItemDTO>> getItem(
            @RequestParam(value = "itemName", required = false) String itemName,
            @RequestParam(value = "dateOfRentedItem", required = false) String dateOfRentedItem,
            @RequestParam(value = "dateOfReturnedItem", required = false) String dateOfReturnedItem,
            @RequestParam(value = "isRented", required = false) String isRented,
            @RequestParam(value = "itemCode", required = false) String itemCode) {
        return ResponseEntity.ok(itemService.getItem(itemName, dateOfRentedItem, dateOfReturnedItem, isRented, itemCode));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<RequestItemDTO> deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }
}