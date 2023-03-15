package ru.practicum.shareit.booking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.booking.dto.BookingDto;
import ru.practicum.shareit.booking.dto.BookingInfoDto;
import ru.practicum.shareit.booking.service.BookingService;

import javax.validation.Valid;
import java.util.List;

import static ru.practicum.shareit.utility.Variables.SHARER_USER_ID;

@RestController
@RequestMapping(path = "/bookings")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public BookingInfoDto create(@RequestHeader(SHARER_USER_ID) Long userId,
                                 @Valid @RequestBody BookingDto bookingDto) {
        return bookingService.create(userId, bookingDto);
    }

    @PatchMapping("/{bookingId}")
    public BookingInfoDto approve(@RequestHeader(SHARER_USER_ID) Long userId, @PathVariable Long bookingId,
                                  @RequestParam Boolean approved
    ) {
        return bookingService.approve(userId, bookingId, approved);
    }

    @GetMapping("/{bookingId}")
    public BookingInfoDto get(@RequestHeader(SHARER_USER_ID) Long userId, @PathVariable Long bookingId) {
        return bookingService.get(userId, bookingId);
    }

    @GetMapping
    public List<BookingInfoDto> get(
            @RequestHeader(SHARER_USER_ID) Long userId,
            @RequestParam(defaultValue = "ALL") String state,
            @RequestParam(defaultValue = "0") Long from,
            @RequestParam(defaultValue = "10") Long size
    ) {
        return bookingService.get(userId, state, from, size);
    }

    @GetMapping("/owner")
    public List<BookingInfoDto> getByOwner(
            @RequestHeader(SHARER_USER_ID) Long userId,
            @RequestParam(defaultValue = "ALL") String state,
            @RequestParam(defaultValue = "0") Long from,
            @RequestParam(defaultValue = "10") Long size
    ) {
        return bookingService.getByOwner(userId, state, from, size);
    }
}