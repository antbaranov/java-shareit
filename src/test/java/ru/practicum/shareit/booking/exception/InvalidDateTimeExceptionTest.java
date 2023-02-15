package ru.practicum.shareit.booking.exception;

import org.junit.jupiter.api.Test;
import ru.practicum.shareit.exception.InvalidDateTimeException;

class InvalidDateTimeExceptionTest {

    @Test
    void invalidDateTimeExceptionTest() {
        InvalidDateTimeException invalidDateTimeException = new InvalidDateTimeException("test");
    }
}