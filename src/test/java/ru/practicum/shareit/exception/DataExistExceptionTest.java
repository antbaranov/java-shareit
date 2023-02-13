package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;

class DataExistExceptionTest {
    @Test
    void dataExistExceptionTest() {
        DataExistException dataExistException = new DataExistException("test");
    }
}