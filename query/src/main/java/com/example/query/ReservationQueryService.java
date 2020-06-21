package com.example.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return queryRepository.findByCheckInDateAfter(yesterday);
    }
}