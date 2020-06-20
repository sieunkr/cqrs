package com.example.command.core.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
