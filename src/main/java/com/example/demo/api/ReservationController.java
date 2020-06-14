package com.example.demo.api;

import com.example.demo.api.dto.ReservationDTO;
import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ReservationDTO getReservation() {
        return reservationService.get();
    }
}
