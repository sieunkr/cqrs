package com.example.command.api;

import com.example.command.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abc")
@RequiredArgsConstructor
public class HomeController {

    private final CustomerService customerService;

    @GetMapping
    public String test() {

        customerService.getFullNameByEmail("jinwoolee2020@gmail.com");

        return "dd";
    }

}
