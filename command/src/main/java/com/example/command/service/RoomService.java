package com.example.command.service;

import com.example.command.core.dto.RoomDTO;
import com.example.command.core.entity.Hotel;
import com.example.command.core.entity.Room;
import com.example.command.core.repository.RoomRepository;
import com.example.command.exception.ExceptionMessage;
import com.example.command.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.command.exception.ExceptionMessage.RESOURCE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomDTO findById(long id) {
        //return RoomDTO.build(roomRepository.findById(id).get());
        return RoomDTO.build(roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND, String.valueOf(id))));
    }









    //아래 소스 코드는, Optional 연습을 위해 작성한 임시 코드..

    public String findCityByRoomId(final long roomId) {

        /*
        Optional<Room> optRoom = roomRepository.findById(roomId);

        if(optRoom.isEmpty()) {
            return "UNKNOWN";
        } else {
            Hotel hotel = optRoom.get().getHotel();
            if(hotel != null) {
                String city = hotel.getCity();
                if(city != null) {
                    return city;
                } else {
                    return "UNKNOWN";
                }
            } else {
                return "UNKNOWN";
            }
        }

         */


        return roomRepository.findById(roomId)
                .map(Room::getHotel)
                .map(Hotel::getCity)
                .orElse("UNKNOWN");



        /*
        return roomRepository.findById(roomId)
                .map(r -> r.getHotel().getCity())
                .orElse("UNKNOWN");

         */

    }
}