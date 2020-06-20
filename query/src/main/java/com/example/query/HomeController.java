package com.example.query;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/query/v1/reservation")
@RequiredArgsConstructor
public class HomeController {

    private final ReservationQueryRepository queryRepository;

    @GetMapping
    List<ReservationDTO> findAll() {
        return queryRepository.findAll();
    }

}
