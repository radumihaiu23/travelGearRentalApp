package com.itschool.travelGearRentalApp.services;

import com.itschool.travelGearRentalApp.models.entities.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecification {

    public static Specification<Item> itemNameContains(String itemName) {
        return (customer, query, criteriaBuilder) -> itemName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(customer.get("firstName")), "%" + itemName.toLowerCase() + "%");
    }
}
