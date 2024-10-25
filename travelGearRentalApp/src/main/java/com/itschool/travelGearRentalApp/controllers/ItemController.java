package com.itschool.travelGearRentalApp.controllers;

import com.itschool.travelGearRentalApp.models.dtos.RequestItemDTO;
import com.itschool.travelGearRentalApp.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/api/items")
    public ResponseEntity<RequestItemDTO> createItem(@RequestBody RequestItemDTO requestItemDTO) {
        return ResponseEntity.ok(itemService.createItem(requestItemDTO));
    }
}
