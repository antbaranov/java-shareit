package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {
    @Test
    void getError() {
        ErrorResponse2 response = new ErrorResponse2("test");
        assertEquals("test", response.getError());
    }

}