package com.example.command.core.repository;

import com.example.command.core.entity.CustomerId;
import com.example.command.core.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationCommandRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByCustomerId(CustomerId customerId);
}