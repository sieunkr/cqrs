package com.example.command.core.event;

import lombok.Getter;

@Getter
public class CustomerChangedEvent {

    private long customerId;

    public CustomerChangedEvent(long customerId) {
        this.customerId = customerId;
    }
}
