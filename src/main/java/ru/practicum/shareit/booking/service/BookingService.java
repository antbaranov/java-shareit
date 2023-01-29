package ru.practicum.shareit.booking.service;

import ru.practicum.shareit.booking.dto.BookingDto;
import ru.practicum.shareit.booking.dto.BookingInfoDto;
import ru.practicum.shareit.booking.exception.BookingNotFoundException;
import ru.practicum.shareit.booking.exception.InvalidDateTimeException;
import ru.practicum.shareit.booking.exception.InvalidStatusException;
import ru.practicum.shareit.booking.exception.NotAvailableException;
import ru.practicum.shareit.item.exception.ItemNotFoundException;
import ru.practicum.shareit.user.exception.UserNotFoundException;

import java.util.List;

public interface BookingService {

    BookingInfoDto create(Long userId, BookingDto bookingDto) throws UserNotFoundException, ItemNotFoundException, NotAvailableException, InvalidDateTimeException;

    BookingInfoDto approve(Long userId, Long bookingId, Boolean approved) throws BookingNotFoundException, UserNotFoundException, InvalidStatusException;

    BookingInfoDto get(Long userId, Long bookingId) throws BookingNotFoundException, UserNotFoundException;

    List<BookingInfoDto> get(Long userId, String state) throws UserNotFoundException, InvalidStatusException;

    List<BookingInfoDto> getByOwner(Long userId, String state) throws UserNotFoundException, InvalidStatusException;
}