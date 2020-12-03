package com.example.command.api;

import com.example.command.core.dto.RoomDTO;
import com.example.command.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public RoomDTO findById(@RequestParam(name = "id") Long roomId) {

        return roomService.findById(roomId);
    }



}
