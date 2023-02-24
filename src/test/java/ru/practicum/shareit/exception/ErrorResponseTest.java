package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorResponseTest {

    @Test
    void getError() {
        ErrorResponse response = new ErrorResponse("test");
        assertEquals("test", response.getError());
    }
}