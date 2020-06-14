package com.example.demo.api.dto;

import com.example.demo.core.entity.Room;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomDTO {

    private long id;
    private long hotelId;
    private long roomTypeId;
    private String roomStatus;

    public static RoomDTO build(Room room) {

        return RoomDTO.builder()
                .id(room.getId())
                .hotelId(room.getHotel().getId())
                .roomTypeId(room.getRoomType().getId())
                .roomStatus(room.getRoomStatus().getName())
                .build();
    }
}