package com.example.command.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SimpleResponse {

    private String status;
    private String message;
}
