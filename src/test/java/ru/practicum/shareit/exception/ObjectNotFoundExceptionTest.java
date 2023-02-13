package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;

class ObjectNotFoundExceptionTest {

    @Test
    void objectNotFoundExceptionTest() {
        ObjectNotFoundException objectNotFoundException = new ObjectNotFoundException("test");
    }
}