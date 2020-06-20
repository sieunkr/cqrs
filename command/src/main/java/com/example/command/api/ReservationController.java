package com.example.command.api;

import com.example.command.core.dto.ReservationDTO;
import com.example.command.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ReservationDTO getReservation(@RequestParam(name = "id") Long reservationId) {
        return reservationService.getReservationInfoById(reservationId);
    }

    @GetMapping("/test")
    public String test(@RequestParam(name = "id") Long reservationId) {
        reservationService.updateReservation(reservationId);
        return "ok";
    }
}
