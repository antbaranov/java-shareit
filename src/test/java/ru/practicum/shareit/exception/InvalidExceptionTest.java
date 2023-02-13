package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;

class InvalidExceptionTest {

    @Test
    void invalidExceptionTest() {
        InvalidException invalidException = new InvalidException("test");
    }

}