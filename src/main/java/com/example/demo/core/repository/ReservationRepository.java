package com.example.demo.core.repository;

import com.example.demo.core.entity.Reservation;
import com.example.demo.core.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
