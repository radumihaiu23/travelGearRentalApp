package com.itschool.travelGearRentalApp.repositories;

import com.itschool.travelGearRentalApp.models.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    Item findByItemName (String itemName);
    Item findByIsRented (String isRented);
}