package com.example.demo.core.repository;

import com.example.demo.core.cache.ReservationQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationQueryRepository extends MongoRepository<ReservationQuery, Long> {
}
