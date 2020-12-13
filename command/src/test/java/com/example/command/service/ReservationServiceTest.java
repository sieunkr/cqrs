package com.example.command.service;

import com.example.command.core.entity.Reservation;
import com.example.command.core.repository.CustomerRepository;
import com.example.command.core.repository.ReservationCommandRepository;
import com.example.command.core.repository.ReservationQueryRepository;
import com.example.command.core.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationCommandRepository reservationCommandRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ReservationQueryRepository reservationQueryRepository;
    @Mock
    private RoomRepository roomRepository;
    @InjectMocks
    private ReservationService reservationService;


    @Test
    void test() {

        //given

        //when
        //...
        
    }

}