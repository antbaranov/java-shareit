package ru.practicum.shareit.booking;

import ru.practicum.shareit.booking.dto.BookingDto;
import ru.practicum.shareit.booking.dto.BookingInfoDto;
import ru.practicum.shareit.exception.InvalidException;
import ru.practicum.shareit.exception.NotAvailableException;
import ru.practicum.shareit.exception.ObjectNotFoundException;

import java.util.List;

public interface BookingService {

    BookingInfoDto create(Long userId, BookingDto bookingDto) throws ObjectNotFoundException, NotAvailableException, InvalidException;

    BookingInfoDto approve(Long userId, Long bookingId, Boolean approved) throws ObjectNotFoundException, InvalidException;

    BookingInfoDto get(Long userId, Long bookingId) throws ObjectNotFoundException;

    List<BookingInfoDto> get(Long userId, String state) throws ObjectNotFoundException, InvalidException;

    List<BookingInfoDto> getByOwner(Long userId, String state) throws ObjectNotFoundException, InvalidException;
}