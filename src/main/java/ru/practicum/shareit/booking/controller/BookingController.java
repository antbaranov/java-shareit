package ru.practicum.shareit.booking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.booking.dto.BookingDto;
import ru.practicum.shareit.booking.dto.BookingInfoDto;
import ru.practicum.shareit.booking.exception.BookingNotFoundException;
import ru.practicum.shareit.booking.exception.InvalidDateTimeException;
import ru.practicum.shareit.booking.exception.InvalidStatusException;
import ru.practicum.shareit.booking.exception.NotAvailableException;
import ru.practicum.shareit.booking.service.BookingService;
import ru.practicum.shareit.item.exception.ItemNotFoundException;
import ru.practicum.shareit.user.exception.UserNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final String X_SHARER_USER_ID = "X-Sharer-User-Id";
    private final BookingService bookingService;

    @PostMapping
    public BookingInfoDto create(
            @RequestHeader(X_SHARER_USER_ID) Long userId,
            @Valid @RequestBody BookingDto bookingDto
    ) throws UserNotFoundException, ItemNotFoundException, InvalidDateTimeException, NotAvailableException {
        return bookingService.create(userId, bookingDto);
    }

    @PatchMapping("/{bookingId}")
    public BookingInfoDto approve(
            @RequestHeader(X_SHARER_USER_ID) Long userId,
            @PathVariable Long bookingId,
            @RequestParam Boolean approved
    ) throws UserNotFoundException, BookingNotFoundException, InvalidStatusException {
        return bookingService.approve(userId, bookingId, approved);
    }

    @GetMapping("/{bookingId}")
    public BookingInfoDto get(@RequestHeader(X_SHARER_USER_ID) Long userId,
                              @PathVariable Long bookingId
    ) throws UserNotFoundException, BookingNotFoundException {
        return bookingService.get(userId, bookingId);
    }

    @GetMapping
    public List<BookingInfoDto> get(
            @RequestHeader(X_SHARER_USER_ID) Long userId,
            @RequestParam(defaultValue = "ALL", required = false) String state
    ) throws UserNotFoundException, InvalidStatusException {
        return bookingService.get(userId, state);
    }

    @GetMapping("/owner")
    public List<BookingInfoDto> getByOwner(
            @RequestHeader(X_SHARER_USER_ID) Long userId,
            @RequestParam(defaultValue = "ALL", required = false) String state
    ) throws UserNotFoundException, InvalidStatusException {
        return bookingService.getByOwner(userId, state);
    }

}
