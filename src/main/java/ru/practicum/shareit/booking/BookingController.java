package ru.practicum.shareit.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.booking.dto.BookingDto;
import ru.practicum.shareit.booking.dto.BookingInfoDto;
import ru.practicum.shareit.exception.InvalidException;
import ru.practicum.shareit.exception.NotAvailableException;
import ru.practicum.shareit.exception.ObjectNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/bookings")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BookingController {

    private final String X_SHARER_USER_ID = "X-Sharer-User-Id";
    private final BookingService bookingService;

    @PostMapping
    public BookingInfoDto create(
            @RequestHeader(X_SHARER_USER_ID) Long userId,
            @Valid @RequestBody BookingDto bookingDto
    ) throws ObjectNotFoundException, InvalidException, NotAvailableException {
        return bookingService.create(userId, bookingDto);
    }

    @PatchMapping("/{bookingId}")
    public BookingInfoDto approve(
            @RequestHeader(X_SHARER_USER_ID) Long userId,
            @PathVariable Long bookingId,
            @RequestParam Boolean approved
    ) throws ObjectNotFoundException, InvalidException {
        return bookingService.approve(userId, bookingId, approved);
    }

    @GetMapping("/{bookingId}")
    public BookingInfoDto get(@RequestHeader(X_SHARER_USER_ID) Long userId,
                              @PathVariable Long bookingId
    ) throws ObjectNotFoundException {
        return bookingService.get(userId, bookingId);
    }

    @GetMapping
    public List<BookingInfoDto> get(
            @RequestHeader(X_SHARER_USER_ID) Long userId,
            @RequestParam(defaultValue = "ALL", required = false) String state
    ) throws ObjectNotFoundException, InvalidException {
        return bookingService.get(userId, state);
    }

    @GetMapping("/owner")
    public List<BookingInfoDto> getByOwner(
            @RequestHeader(X_SHARER_USER_ID) Long userId,
            @RequestParam(defaultValue = "ALL", required = false) String state
    ) throws ObjectNotFoundException, InvalidException {
        return bookingService.getByOwner(userId, state);
    }

}