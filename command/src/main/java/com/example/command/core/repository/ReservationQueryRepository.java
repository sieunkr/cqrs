package com.example.command.core.repository;

import com.example.command.core.dto.ReservationDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationQueryRepository extends MongoRepository<ReservationDTO, Long> {
}