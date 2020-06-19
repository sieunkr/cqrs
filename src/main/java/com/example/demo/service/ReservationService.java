package com.example.demo.service;

import com.example.demo.api.dto.ReservationDTO;
import com.example.demo.core.entity.Reservation;
import com.example.demo.core.entity.Room;
import com.example.demo.core.repository.ReservationRepository;
import com.example.demo.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public ReservationDTO get() {

        Reservation reservation = reservationRepository.findById(1l).get();
        ReservationDTO reservationDTO = ReservationDTO.build(reservation);
        Room room = roomRepository.findById(reservation.getRoomId().getId()).get();
        reservationDTO.setRoomType(room.getRoomType().getName());

        return reservationDTO;
    }
}