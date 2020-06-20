package com.example.demo.service;

import com.example.demo.core.dto.ReservationDTO;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.CustomerId;
import com.example.demo.core.entity.Reservation;
import com.example.demo.core.entity.Room;
import com.example.demo.core.repository.CustomerRepository;
import com.example.demo.core.repository.ReservationQueryRepository;
import com.example.demo.core.repository.ReservationRepository;
import com.example.demo.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {

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
                .hotel(room.getHotel().getFullName())
                .roomType(room.getRoomType().getName())
                .adults(reservation.getAdults())
                .children(reservation.getChildren())
                .checkInDate(reservation.getCheckInDate())
                .checkOutDate(reservation.getCheckOutDate())
                .fullName(customer.getFullName())
                .phone(customer.getPhone())
                .build();
    }

    public List<Reservation> testByCustomerId(long customerId) {

        return reservationRepository.findAllByCustomerId(new CustomerId(customerId));
    }

    public void updateReservation(long reservationId) {

        Reservation reservation = reservationRepository.findById(reservationId).get();
        Room room = roomRepository.findById(reservation.getRoomId().getId()).get();
        Customer customer = customerRepository.findById(reservation.getCustomerId().getId()).get();

        ReservationDTO reservationQuery = ReservationDTO.builder()
                .id(reservation.getId())
                .hotel(room.getHotel().getFullName())
                .roomType(room.getRoomType().getName())
                .adults(reservation.getAdults())
                .children(reservation.getChildren())
                .checkInDate(reservation.getCheckInDate())
                .checkOutDate(reservation.getCheckOutDate())
                .fullName(customer.getFullName())
                .phone(customer.getPhone())
                .build();

        reservationQueryRepository.save(reservationQuery);
    }


    public ReservationDTO findById(long id) {
        return reservationQueryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(""));
    }

    public List<ReservationDTO> findAll() {
        return reservationQueryRepository.findAll();
    }
}