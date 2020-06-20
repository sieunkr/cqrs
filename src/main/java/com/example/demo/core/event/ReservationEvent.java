package com.example.demo.core.event;

import lombok.Getter;

@Getter
public class ReservationEvent {

    private long customerId;

    public ReservationEvent(long customerId) {
        this.customerId = customerId;
    }
}
