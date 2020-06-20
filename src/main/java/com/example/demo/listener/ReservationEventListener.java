package com.example.demo.listener;

import com.example.demo.core.entity.Reservation;
import com.example.demo.core.event.ReservationEvent;
import com.example.demo.service.ReservationCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationEventListener {

    private final ReservationCommandService reservationCommandService;

    @EventListener
    public void update(ReservationEvent event) {

        //event.getCustomerId();

        List<Reservation> list = reservationCommandService.testByCustomerId(event.getCustomerId());

        list.forEach(reservation -> {
            reservationCommandService.updateReservation(reservation.getId());
        });
    }
}