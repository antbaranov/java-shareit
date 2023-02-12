package ru.practicum.shareit.booking.exception;

import org.junit.jupiter.api.Test;
import ru.practicum.shareit.exception.ObjectNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class BookingNotFoundExceptionTest {

    @Test
    void bookingNotFoundExceptionTest() {
        BookingNotFoundException bookingNotFoundException = new BookingNotFoundException("test");
    }
}