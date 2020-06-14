package com.example.demo.service;

import com.example.demo.api.dto.ReservationDTO;
import com.example.demo.core.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationDTO get() {
        return ReservationDTO.build(reservationRepository.findById(1l).get());
    }
}
