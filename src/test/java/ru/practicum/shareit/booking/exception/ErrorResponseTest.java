package ru.practicum.shareit.booking.exception;

import org.junit.jupiter.api.Test;
import ru.practicum.shareit.exception.ErrorResponse2;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {

    @Test
    void getError() {
        ErrorResponse2 response = new ErrorResponse2("test");
        assertEquals("test", response.getError());
    }
}