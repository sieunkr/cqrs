package com.example.demo.core.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Builder
@Document(collection = "reservation")
public class ReservationDTO {

    @Id
    private long id;
    private String hotel;
    private String roomType;
    private long adults;
    private long children;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String fullName;
    private String phone;
    private String email;

    public static ReservationDTO empty() {
        return ReservationDTO.builder().build();
    }

}