package ru.practicum.shareit.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private String error;
    private String descriptions;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public ErrorResponse(String error, String descriptions) {
        this.error = error;
        this.descriptions = descriptions;
    }
}
