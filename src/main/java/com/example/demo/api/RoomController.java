package com.example.demo.api;

import com.example.demo.core.dto.RoomDTO;
import com.example.demo.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public RoomDTO findById() {

        return roomService.findById(1l);
    }



}
