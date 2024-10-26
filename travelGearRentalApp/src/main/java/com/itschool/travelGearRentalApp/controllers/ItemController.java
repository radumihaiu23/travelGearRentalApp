package com.itschool.travelGearRentalApp.controllers;

import com.itschool.travelGearRentalApp.models.dtos.RequestItemDTO;
import com.itschool.travelGearRentalApp.services.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}