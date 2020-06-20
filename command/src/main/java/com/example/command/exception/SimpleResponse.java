package com.example.command.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SimpleResponse {

    private int status;
    private String message;
}
