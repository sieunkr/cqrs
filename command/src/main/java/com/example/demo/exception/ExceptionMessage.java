package com.example.demo.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    INTERNAL_API_ERROR("알수 없는 에러가 발생하였습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
