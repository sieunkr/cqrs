package com.example.command.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "API 에러")
@NoArgsConstructor
public class ApiRuntimeException extends RuntimeException {

    public ApiRuntimeException(ExceptionMessage message) {
        super(message.getMessage());
    }
}