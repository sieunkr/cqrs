package com.example.demo.api.dto;

import com.example.demo.core.entity.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ReservationDTO {

    private long id;
    private String hotel;
    private String roomType;
    private long adults;
    private long children;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String fullName;
    private String phone;

    /*
    public static ReservationDTO build(Reservation reservation) {
        return ReservationDTO.builder()
                .fullName(reservation.getCustomer().getFirstName() + reservation.getCustomer().getLastName())
                .id(reservation.getId())
                .build();
    }

     */
}
