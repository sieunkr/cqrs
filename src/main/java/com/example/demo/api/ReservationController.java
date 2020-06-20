package com.example.demo.api;

import com.example.demo.api.dto.ReservationDTO;
import com.example.demo.core.cache.ReservationQuery;
import com.example.demo.service.ReservationCommandService;
import com.example.demo.service.ReservationQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationCommandService reservationCommandService;
    private final ReservationQueryService reservationQueryService;

    @GetMapping
    public ReservationDTO getReservation() {
        return reservationCommandService.getReservationInfoById();
    }

    @GetMapping("/test")
    public String test() {
        reservationCommandService.updateReservation();
        return "ok";

    }

    @GetMapping("/find")
    public List<ReservationQuery> findAll() {
        return reservationQueryService.findAll();

    }
}
