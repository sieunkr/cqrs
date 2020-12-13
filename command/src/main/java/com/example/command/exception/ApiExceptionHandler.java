package com.example.command.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;


//TODO:
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SimpleResponse apiRuntimeException(ApiRuntimeException ex, WebRequest request) {

        return SimpleResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .build();
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SimpleResponse handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

        return SimpleResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .build();
    }

    /* TODO: 확인..
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SimpleResponse exception(Exception ex, WebRequest request) {
        return SimpleResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }
     */
}
