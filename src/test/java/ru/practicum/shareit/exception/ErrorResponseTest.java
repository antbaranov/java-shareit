package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;
import ru.practicum.shareit.booking.exception.ErrorResponse;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {
    @Test
    void getError() {
        ErrorResponse response = new ErrorResponse("test");
        assertEquals("test", response.getError());
    }

}