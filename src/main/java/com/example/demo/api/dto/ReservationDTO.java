package com.example.demo.api.dto;

import com.example.demo.core.entity.Reservation;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReservationDTO {

    private long id;
    private String fullName;

    public static ReservationDTO build(Reservation reservation) {
        return ReservationDTO.builder()
                .fullName(reservation.getCustomer().getFirstName() + reservation.getCustomer().getLastName())
                .id(reservation.getId())
                .build();
    }
}
