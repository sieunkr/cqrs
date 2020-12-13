package com.example.command.service;

import com.example.command.core.dto.ReservationDTO;
import com.example.command.core.entity.Customer;
import com.example.command.core.entity.CustomerId;
import com.example.command.core.entity.Reservation;
import com.example.command.core.entity.Room;
import com.example.command.core.repository.CustomerRepository;
import com.example.command.core.repository.ReservationCommandRepository;
import com.example.command.core.repository.ReservationQueryRepository;
import com.example.command.core.repository.RoomRepository;
import com.example.command.exception.ApiRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static com.example.command.exception.ExceptionMessage.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationCommandRepository reservationCommandRepository;
    private final CustomerRepository customerRepository;
    private final ReservationQueryRepository reservationQueryRepository;
    private final RoomRepository roomRepository;

    public List<Reservation> getReservationByCustomerId(long customerId) {

        return reservationCommandRepository.findAllByCustomerId(new CustomerId(customerId));
    }

    public ReservationDTO getReservationDTO(long reservationId) {

        return getReservationDTOImpl(reservationId);
    }

    public void updateReservationDTO(long reservationId) {

        ReservationDTO reservationDTO = getReservationDTOImpl(reservationId);
        reservationQueryRepository.save(reservationDTO);
    }

    private ReservationDTO getReservationDTOImpl(long reservationId) {

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




    //아래 소스 코드는, Optional 연습을 위해 작성한 임시 코드..



}