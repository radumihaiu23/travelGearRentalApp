package com.itschool.travelGearRentalApp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.travelGearRentalApp.models.dtos.PostItemDTO;
import com.itschool.travelGearRentalApp.models.entities.Item;
import com.itschool.travelGearRentalApp.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public PostItemDTO createItem(PostItemDTO postItemDTO) {
        Item itemEntity = objectMapper.convertValue(postItemDTO, Item.class);
        Item itemEntityResponse = itemRepository.save(itemEntity);
        log.info(" Item with id {} was saved in database ", itemEntityResponse.getID());
        return null;
    }
}