package com.example.command.service;

import com.example.command.core.entity.Hotel;
import com.example.command.core.entity.Room;
import com.example.command.core.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    @Test
    void testFindCityByRoomId() {

        //given
        long loomId = 1L;
        String actualCityName;
        Optional<Room> optRoom = Optional.of(Room.builder().id(1L).hotel(Hotel.builder().city("INCHON").build()).build());
        given(roomRepository.findById(anyLong())).willReturn(optRoom);

        //when
        actualCityName = roomService.findCityByRoomId(loomId);

        //then
        assertEquals("INCHON", actualCityName);
    }

    @Test
    void givenHotelIsNull_whenFindCityByRoomId_thenCityUnknown() {

        //given
        long loomId = 1L;
        String actualCityName;
        Optional<Room> optRoom = Optional.of(Room.builder().id(1L).build());
        given(roomRepository.findById(anyLong())).willReturn(optRoom);

        //when
        actualCityName = roomService.findCityByRoomId(loomId);

        //then
        assertEquals("UNKNOWN", actualCityName);
    }

}