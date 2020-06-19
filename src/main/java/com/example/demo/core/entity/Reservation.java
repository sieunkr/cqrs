package com.example.demo.core.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "room_id"))
    )
    private RoomId roomId;

    @Column(name = "adults")
    private Long adults;

    @Column(name = "children")
    private Long children;

    @Column(name = "reservation_time")
    @CreatedDate    //TODO: 적합하지 않음
    private LocalDateTime reservationTime;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}