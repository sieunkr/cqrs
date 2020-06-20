package com.example.demo.service;

import com.example.demo.core.dto.ReservationDTO;
import com.example.demo.core.entity.Customer;
import com.example.demo.core.entity.CustomerId;
import com.example.demo.core.entity.Reservation;
import com.example.demo.core.entity.Room;
import com.example.demo.core.repository.CustomerRepository;
import com.example.demo.core.repository.ReservationCommandRepository;
import com.example.demo.core.repository.ReservationQueryRepository;
import com.example.demo.core.repository.RoomRepository;
import com.example.demo.exception.ApiRuntimeException;
import com.example.demo.exception.ExceptionMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static com.example.demo.exception.ExceptionMessage.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationCommandRepository reservationCommandRepository;
    private final ReservationQueryRepository reservationQueryRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    public List<Reservation> getReservationByCustomerId(long customerId) {

        return reservationCommandRepository.findAllByCustomerId(new CustomerId(customerId));
    }

    public ReservationDTO getReservationInfoById(long reservationId) {

        return getDTO(reservationId);
    }

    public void updateReservation(long reservationId) {

        ReservationDTO reservationDTO = getDTO(reservationId);
        reservationQueryRepository.save(reservationDTO);
    }

    private ReservationDTO getDTO(long reservationId) {

        Assert.notNull(reservationId, "ReservationId must not be null");

        Reservation reservation = reservationCommandRepository.findById(reservationId)
                .orElseThrow(() -> {
                    throw new ApiRuntimeException(INTERNAL_API_ERROR);
                });
        Room room = roomRepository.findById(reservation.getRoomId().getId())
                .orElseThrow(() -> {
                    throw new ApiRuntimeException(INTERNAL_API_ERROR);
                });
        Customer customer = customerRepository.findById(reservation.getCustomerId().getId())
                .orElseThrow(() -> {
                    throw new ApiRuntimeException(INTERNAL_API_ERROR);
                });

        return ReservationDTO.builder()
                .id(reservation.getId())
                .adults(reservation.getAdults())
                .children(reservation.getChildren())
                .checkInDate(reservation.getCheckInDate())
                .checkOutDate(reservation.getCheckOutDate())
                .hotel(room.getHotel().getFullName())
                .roomType(room.getRoomType().getName())
                .fullName(customer.getFullName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .build();
    }


    public ReservationDTO queryFindByReservationId(long reservationId) {

        return reservationQueryRepository.findById(reservationId)
                .orElse(ReservationDTO.empty());
    }

    public List<ReservationDTO> queryFindAll() {

        return reservationQueryRepository.findAll();
    }
}