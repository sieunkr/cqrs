package com.example.demo.core.repository;

import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
