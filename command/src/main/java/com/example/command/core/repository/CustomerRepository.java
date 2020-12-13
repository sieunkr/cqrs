package com.example.command.core.repository;

import com.example.command.core.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Customer findByEmail(String email);
    Optional<Customer> findByEmail(String email);
    List<Customer> findAllByLastName(String lastName);
}