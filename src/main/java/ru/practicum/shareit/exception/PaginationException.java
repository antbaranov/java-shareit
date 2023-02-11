package ru.practicum.shareit.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PaginationException extends RuntimeException {
    public PaginationException(String message) {
        super(message);
    }

    @RequiredArgsConstructor
    @Getter
    public static class ErrorResponse {
        private final String error;

    }
}