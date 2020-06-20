package com.example.demo.core.repository;

import com.example.demo.core.entity.CustomerId;
import com.example.demo.core.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationCommandRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByCustomerId(CustomerId customerId);
}