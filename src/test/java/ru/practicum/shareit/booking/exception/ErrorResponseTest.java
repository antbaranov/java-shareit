package ru.practicum.shareit.booking.exception;

import org.junit.jupiter.api.Test;

class ErrorResponseTest {

    @Test
    void getError() {
        ErrorResponse2 response = new ErrorResponse2("test");
        assertEquals("test", response.getError());
    }
}