package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;
import ru.practicum.shareit.exception.BookingNotFoundException;

class BookingNotFoundExceptionTest {

    @Test
    void bookingNotFoundExceptionTest() {
        BookingNotFoundException bookingNotFoundException = new BookingNotFoundException("test");
    }
}