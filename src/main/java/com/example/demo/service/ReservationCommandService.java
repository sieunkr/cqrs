package com.example.demo.service;

import com.example.demo.api.dto.ReservationDTO;
import com.example.demo.core.cache.ReservationQuery;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.Reservation;
import com.example.demo.core.entity.Room;
import com.example.demo.core.repository.CustomerRepository;
import com.example.demo.core.repository.ReservationQueryRepository;
import com.example.demo.core.repository.ReservationRepository;
import com.example.demo.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationCommandService {

    private final ReservationRepository reservationRepository;
    private final ReservationQueryRepository reservationQueryRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    public ReservationDTO getReservationInfoById() {

        Reservation reservation = reservationRepository.findById(1l).get();
        Room room = roomRepository.findById(reservation.getRoomId().getId()).get();
        Customer customer = customerRepository.findById(reservation.getCustomerId().getId()).get();

        return ReservationDTO.builder()
                .id(reservation.getId())
                .hotel(room.getHotel().getCity() + " " + room.getHotel().getName())
                .roomType(room.getRoomType().getName())
                .adults(reservation.getAdults())
                .children(reservation.getChildren())
                .checkInDate(reservation.getCheckInDate())
                .checkOutDate(reservation.getCheckOutDate())
                .fullName(customer.getFirstName() + " " + customer.getLastName())
                .phone(customer.getPhone())
                .build();
    }

    public List<Reservation> testByCustomerId(long customerId) {

        return reservationRepository.findByCustomerId(customerId);
    }

    @Async
    public void updateReservation(long reservationId) {

        Reservation reservation = reservationRepository.findById(1l).get();
        Room room = roomRepository.findById(reservation.getRoomId().getId()).get();
        Customer customer = customerRepository.findById(reservation.getCustomerId().getId()).get();

        ReservationQuery reservationQuery = ReservationQuery.builder()
                .id(reservation.getId())
                .hotel(room.getHotel().getCity() + " " + room.getHotel().getName())
                .roomType(room.getRoomType().getName())
                .adults(reservation.getAdults())
                .children(reservation.getChildren())
                .checkInDate(reservation.getCheckInDate())
                .checkOutDate(reservation.getCheckOutDate())
                .fullName(customer.getFirstName() + " " + customer.getLastName())
                .phone(customer.getPhone())
                .build();

        reservationQueryRepository.save(reservationQuery);
    }
}