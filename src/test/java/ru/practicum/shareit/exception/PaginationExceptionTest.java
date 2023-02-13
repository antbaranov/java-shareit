package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;

class PaginationExceptionTest {

    @Test
    void paginationExceptionTest() {
        PaginationException paginationException = new PaginationException("test");
    }
}