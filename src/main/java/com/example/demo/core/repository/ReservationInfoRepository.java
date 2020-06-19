package com.example.demo.core.repository;

import com.example.demo.core.cache.ReservationInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationInfoRepository extends MongoRepository<ReservationInfo, Long> {
}
