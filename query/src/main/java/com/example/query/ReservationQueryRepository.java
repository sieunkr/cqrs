package com.example.query;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationQueryRepository extends MongoRepository<ReservationDTO, Long> {

    //TODO: 메서드 길어진다면, @Query 어노테이션 또는 MongoTemplate를 사용하는게 좋을수도..
    List<ReservationDTO> findByCheckInDateAfter(LocalDate checkInDate);

}