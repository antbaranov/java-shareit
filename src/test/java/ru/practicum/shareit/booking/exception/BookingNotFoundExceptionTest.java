package ru.practicum.shareit.booking.exception;

import org.junit.jupiter.api.Test;

class BookingNotFoundExceptionTest {

    @Test
    void bookingNotFoundExceptionTest() {
        BookingNotFoundException bookingNotFoundException = new BookingNotFoundException("test");
    }
}