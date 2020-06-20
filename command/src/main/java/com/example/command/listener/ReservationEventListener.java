package com.example.command.listener;

import com.example.command.core.entity.Reservation;
import com.example.command.core.event.CustomerChangedEvent;
import com.example.command.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationEventListener {

    private final ReservationService reservationService;

    @EventListener
    public void update(CustomerChangedEvent event) {

        List<Reservation> list = reservationService.getReservationByCustomerId(event.getCustomerId());

        list.forEach(reservation -> {
            reservationService.updateReservation(reservation.getId());
        });
    }
}