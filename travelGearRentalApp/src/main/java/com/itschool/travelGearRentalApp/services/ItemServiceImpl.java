package com.itschool.travelGearRentalApp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.travelGearRentalApp.exceptions.ItemDatabaseIsEmptyException;
import com.itschool.travelGearRentalApp.exceptions.ItemNameAlreadyExistsException;
import com.itschool.travelGearRentalApp.exceptions.ItemNotFoundException;
import com.itschool.travelGearRentalApp.models.dtos.RequestItemDTO;
import com.itschool.travelGearRentalApp.models.dtos.ResponseItemDTO;
import com.itschool.travelGearRentalApp.models.entities.Item;
import com.itschool.travelGearRentalApp.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
            itemEntity.setIsRented("no");
        }
        itemEntity.setItemCode(UUID.randomUUID());
        Item itemEntityResponse = itemRepository.save(itemEntity);
        log.info(" Item with id {} was saved in database ", itemEntityResponse.getID());

        return objectMapper.convertValue(itemEntityResponse, RequestItemDTO.class);
    }

    @Override
    public List<ResponseItemDTO> getItem(String itemName, String dateOfRentedItem, String dateOfReturnedItem, String isRented, String itemCode) {
        Specification<Item> spec = Specification
                .where(ItemSpecification.itemNameContains(itemName))
                .and(ItemSpecification.dateOfRentedItemContains(dateOfRentedItem))
                .and(ItemSpecification.dateOfReturnedItemContains(dateOfReturnedItem))
                .and(ItemSpecification.isRentedContains(isRented))
                .and(ItemSpecification.itemCodeContains(itemCode));

        List<Item> filteredItems = itemRepository.findAll(spec);
        log.info("{} customers were found", filteredItems.size());

        if (filteredItems.isEmpty()) {
            throw new ItemDatabaseIsEmptyException("Customer database is empty");
        }

        return filteredItems.stream()
                .map(item -> objectMapper.convertValue(item, ResponseItemDTO.class))
                .toList();
    }

    @Override
    public void deleteItemById(Long itemId) {
        itemRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException("Item: " + itemId + " cannot be found in database "));
        itemRepository.deleteById(itemId);
        log.info("All data for item id: {} was deleted", itemId);
    }


    public void validateItemName(RequestItemDTO requestItemDTO) {
        Item item = itemRepository.findByItemName(requestItemDTO.getItemName());
        if (item != null) {
            throw new ItemNameAlreadyExistsException("This itemName already exists in database");
        }
    }
}