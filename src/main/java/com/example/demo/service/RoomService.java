package com.example.demo.service;

import com.example.demo.api.dto.RoomDTO;
import com.example.demo.core.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomDTO findById(long id) {
        return RoomDTO.build(roomRepository.findById(id).get());
    }

}
