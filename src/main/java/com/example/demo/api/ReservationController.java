package com.example.demo.api;

import com.example.demo.api.dto.ReservationDTO;
import com.example.demo.core.cache.ReservationInfo;
import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ReservationDTO getReservation() {
        return reservationService.getReservationInfoById();
    }

    @GetMapping("/test")
    public String test() {
        reservationService.updateReservation();
        return "ok";

    }

    @GetMapping("/find")
    public List<ReservationInfo> findAll() {
        return reservationService.findAll();

    }
}
