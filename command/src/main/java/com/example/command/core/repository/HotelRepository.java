package com.example.command.core.repository;

import com.example.command.core.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    //TODO: 응답 지연 테스트를 위한 임시 쿼리...
    @Modifying
    @Query(value = "INSERT INTO hotel(id, city, name) VALUES ( '1', (SELECT SLEEP(5)), 'test')", nativeQuery = true)
    void save();
}