package ru.practicum.shareit.booking.exception;

import org.junit.jupiter.api.Test;

class InvalidDateTimeExceptionTest {

    @Test
    void invalidDateTimeExceptionTest() {
        InvalidDateTimeException invalidDateTimeException = new InvalidDateTimeException("test");
    }
}