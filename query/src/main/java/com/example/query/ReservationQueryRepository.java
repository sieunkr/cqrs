package com.example.query;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationQueryRepository extends MongoRepository<ReservationDTO, Long> {

    //TODO: 메서드가 너무 길어서 가독성이 떨어짐. 차라리 @Query 어노테이션 또는 MongoTemplate를 사용하는게 좋을 듯
    List<ReservationDTO> findByCheckInDateBeforeAndCheckOutDateAfter(Date checkInDate, Date checkOutDate);

}