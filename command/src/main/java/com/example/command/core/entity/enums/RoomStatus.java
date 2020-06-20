package com.example.command.core.entity.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoomStatus {

    ON("사용 중"),
    NO("수리 중");

    private String description;

    RoomStatus(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name();
    }

}
