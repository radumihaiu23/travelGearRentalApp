package com.itschool.travelGearRentalApp.services;

import com.itschool.travelGearRentalApp.models.entities.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecification {

    public static Specification<Item> itemNameContains(String itemName) {
        return (item, query, criteriaBuilder) -> itemName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(item.get("itemName")), "%" + itemName.toLowerCase() + "%");
    }

    public static Specification<Item> dateOfRentedItemContains(String dateOfRentedItem) {
        return (item, query, criteriaBuilder) -> dateOfRentedItem == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(item.get("dateOfRentedItem")), "%" + dateOfRentedItem.toLowerCase() + "%");
    }

    public static Specification<Item> dateOfReturnedItemContains(String dateOfReturnedItem) {
        return (item, query, criteriaBuilder) -> dateOfReturnedItem == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(item.get("dateOfReturnedItem")), "%" + dateOfReturnedItem.toLowerCase() + "%");
    }

    public static Specification<Item> isRentedContains(String isRented) {
        return (item, query, criteriaBuilder) -> isRented == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(item.get("isRented")), "%" + isRented.toLowerCase() + "%");
    }

    public static Specification<Item> itemCodeContains(String itemCode) {
        return (item, query, criteriaBuilder) -> itemCode == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(item.get("itemCode")), "%" + itemCode.toLowerCase() + "%");
    }
}