package com.example.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationQueryService {

    private final ReservationQueryRepository queryRepository;

    public ReservationDTO findById(long id) {
        return queryRepository.findById(id).get();
    }

    public List<ReservationDTO> findAll() {
        return queryRepository.findAll();
    }

    public List<ReservationDTO> findByToday() {
        LocalDate localDate = LocalDate.now();
        Date today = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        return queryRepository.findByCheckInDateBeforeAndCheckOutDateAfter(today, today);
    }
}