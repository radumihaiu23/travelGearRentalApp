package com.itschool.travelGearRentalApp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.travelGearRentalApp.exceptions.ItemNameAlreadyExistsException;
import com.itschool.travelGearRentalApp.models.dtos.RequestItemDTO;
import com.itschool.travelGearRentalApp.models.entities.Item;
import com.itschool.travelGearRentalApp.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    private final ObjectMapper objectMapper;
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ObjectMapper objectMapper, ItemRepository itemRepository) {
        this.objectMapper = objectMapper;
        this.itemRepository = itemRepository;
    }

    @Override
    public RequestItemDTO createItem(RequestItemDTO requestItemDTO) {
        validateItemName(requestItemDTO);
        Item itemEntity = objectMapper.convertValue(requestItemDTO, Item.class);
        itemEntity.setDateOfRentedItem(LocalDateTime.now());
        if (itemEntity.getDateOfRentedItem() != null) {
            itemEntity.setIsRented(true);
        }
        itemEntity.setItemCode(UUID.randomUUID());
        Item itemEntityResponse = itemRepository.save(itemEntity);
        log.info(" Item with id {} was saved in database ", itemEntityResponse.getID());

        return objectMapper.convertValue(itemEntityResponse, RequestItemDTO.class);
    }


    public void validateItemName(RequestItemDTO requestItemDTO) {
        Item item = itemRepository.findByItemName(requestItemDTO.getItemName());
        if (item != null) {
            throw new ItemNameAlreadyExistsException("This itemName already exists in database");
        }
    }


}