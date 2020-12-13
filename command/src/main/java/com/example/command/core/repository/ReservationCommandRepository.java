package com.example.command.core.repository;

import com.example.command.core.entity.CustomerId;
import com.example.command.core.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationCommandRepository extends JpaRepository<Reservation, Long> {
    //Optional<List<Reservation>> findAllByCustomerId(CustomerId customerId);  //avoid
    List<Reservation> findAllByCustomerId(CustomerId customerId);   //TODO: 확인
    Optional<Reservation> findFirstByCustomerIdOrderByReservationTimeDesc(CustomerId customerId);
}