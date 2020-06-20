package com.example.demo.service;

import com.example.demo.core.cache.ReservationQuery;
import com.example.demo.core.repository.ReservationQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationQueryService {

    private final ReservationQueryRepository reservationQueryRepository;

    public List<ReservationQuery> findAll() {
        return reservationQueryRepository.findAll();
    }
}
