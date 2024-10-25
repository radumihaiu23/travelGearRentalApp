package com.itschool.travelGearRentalApp.services;

import com.itschool.travelGearRentalApp.models.entities.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {

    //firstName, lastName, email, customerCode, customerGender
    public static Specification<Customer> firstNameContains(String firstName) {
        return (customer, query, criteriaBuilder) -> firstName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(customer.get("firstName")), "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<Customer> lastNameContains(String lastName) {
        return (customer, query, criteriaBuilder) -> lastName == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(customer.get("lastName")), "%" + lastName.toLowerCase() + "%");
    }

    public static Specification<Customer> emailContains(String email) {
        return (customer, query, criteriaBuilder) -> email == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(customer.get("email")), "%" + email.toLowerCase() + "%");
    }

    public static Specification<Customer> customerGenderContains(String customerGender) {
        return (customer, query, criteriaBuilder) -> customerGender == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(customer.get("customerGender")), "%" + customerGender.toLowerCase() + "%");
    }

    public static Specification<Customer> customerIdContains(String id) {
        return (customer, query, criteriaBuilder) -> id == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(customer.get("id")), "%" + id.toLowerCase() + "%");
    }

    public static Specification<Customer> customerCodeContains(String customerCode) {
        return (customer, query, criteriaBuilder) -> customerCode == null ? null :
                criteriaBuilder.like(criteriaBuilder.lower(customer.get("customerCode")), "%" + customerCode.toLowerCase() + "%");
    }
}