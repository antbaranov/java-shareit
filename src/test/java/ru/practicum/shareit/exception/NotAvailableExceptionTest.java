package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;

class NotAvailableExceptionTest {
    @Test
    void notAvailableExceptionTest() {
        NotAvailableException notAvailableException = new NotAvailableException("test");
    }

}