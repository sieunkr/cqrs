package com.example.demo.api.dto;

import com.example.demo.core.entity.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReservationDTO {

    private long id;
    private String fullName;
    private String roomType;

    public static ReservationDTO build(Reservation reservation) {
        return ReservationDTO.builder()
                .fullName(reservation.getCustomer().getFirstName() + reservation.getCustomer().getLastName())
                .id(reservation.getId())
                .build();
    }
}
