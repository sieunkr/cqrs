package com.example.command.api;

import com.example.command.core.dto.CustomerDTO;
import com.example.command.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }


    @GetMapping("/test")
    public String test(@RequestParam(name = "id") Long reservationId) {
        customerService.changeFullName(1l, "sieun", "kim");
        return "ok";
    }
}