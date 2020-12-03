package com.example.command.service;

import com.example.command.core.dto.RoomDTO;
import com.example.command.core.repository.RoomRepository;
import com.example.command.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.command.exception.ExceptionMessage.RESOURCE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomDTO findById(long id) {
        //return RoomDTO.build(roomRepository.findById(id).get());
        return RoomDTO.build(roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND)));
    }

}
