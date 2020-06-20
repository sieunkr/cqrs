package com.example.demo.listener;

import com.example.demo.core.entity.Reservation;
import com.example.demo.core.event.ReservationEvent;
import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationEventListener {

    private final ReservationService reservationService;

    @EventListener
    public void update(ReservationEvent event) {

        List<Reservation> list = reservationService.testByCustomerId(event.getCustomerId());

        list.forEach(reservation -> {
            reservationService.updateReservation(reservation.getId());
        });
    }
}