package com.example.demo.core.repository;

import com.example.demo.core.dto.ReservationDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationQueryRepository extends MongoRepository<ReservationDTO, Long> {
}