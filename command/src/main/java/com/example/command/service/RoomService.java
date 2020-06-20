package com.example.command.service;

import com.example.command.core.dto.RoomDTO;
import com.example.command.core.repository.RoomRepository;
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
