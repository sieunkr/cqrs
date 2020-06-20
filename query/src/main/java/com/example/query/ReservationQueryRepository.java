package com.example.query;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationQueryRepository extends MongoRepository<ReservationDTO, Long> {
}