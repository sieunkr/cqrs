package com.example.query;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/query/v1/reservation")
@RequiredArgsConstructor
public class HomeController {

    private final ReservationQueryService queryService;

    @GetMapping
    List<ReservationDTO> findAll() {
        return queryService.findAll();
    }

    @GetMapping("/today")
    List<ReservationDTO> today() {
        return queryService.findByToday();
    }

    @GetMapping("/{id}")
    ReservationDTO findById(@PathVariable(name = "id") Long id) {
        return queryService.findById(id);
    }



}
