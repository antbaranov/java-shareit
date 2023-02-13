package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;

class ValidationExceptionTest {

    @Test
    void validationExceptionTest() {
        ValidationException validationException = new ValidationException("test");
    }
}