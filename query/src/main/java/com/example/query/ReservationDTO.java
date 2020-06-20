package com.example.query;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

}