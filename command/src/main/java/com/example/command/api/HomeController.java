package com.example.command.api;

import com.example.command.core.repository.HotelRepository;
import com.example.command.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/abc")
@RequiredArgsConstructor
public class HomeController {

    private final CustomerService customerService;
    private final HotelRepository hotelRepository;

    @GetMapping
    public String test() {

        customerService.getFullNameByEmail("jinwoolee2020@gmail.com");

        return "dd";
    }

    @GetMapping("/delay")
    @Transactional
    public String test02() {

        hotelRepository.save();
        return "ok";
    }
}