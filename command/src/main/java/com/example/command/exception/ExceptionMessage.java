package com.example.command.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    INTERNAL_API_ERROR("알수 없는 에러가 발생하였습니다."),
    RESOURCE_NOT_FOUND("리소스를 찾을 수 없습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
