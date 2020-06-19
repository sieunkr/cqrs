package com.example.demo.service;

import com.example.demo.api.dto.ReservationDTO;
import com.example.demo.core.cache.ReservationInfo;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.CustomerId;
import com.example.demo.core.entity.Reservation;
import com.example.demo.core.entity.Room;
import com.example.demo.core.repository.CustomerRepository;
import com.example.demo.core.repository.ReservationInfoRepository;
import com.example.demo.core.repository.ReservationRepository;
import com.example.demo.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationInfoRepository reservationInfoRepository;
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

    public void updateReservation() {

        Reservation reservation = reservationRepository.findById(1l).get();
        Room room = roomRepository.findById(reservation.getRoomId().getId()).get();
        Customer customer = customerRepository.findById(reservation.getCustomerId().getId()).get();

        ReservationInfo reservationInfo = ReservationInfo.builder()
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

        reservationInfoRepository.save(reservationInfo);
    }

    public List<ReservationInfo> findAll() {
        return reservationInfoRepository.findAll();
    }
}