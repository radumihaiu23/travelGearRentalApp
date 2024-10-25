package com.itschool.travelGearRentalApp.repositories;

import com.itschool.travelGearRentalApp.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    Customer findByEmail(String email);
    Customer findByFirstName(String firstName);
    Customer findByLastName(String lastName);

}