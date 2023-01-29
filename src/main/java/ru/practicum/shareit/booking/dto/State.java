package ru.practicum.shareit.booking.dto;

import ru.practicum.shareit.booking.exception.InvalidStatusException;

public enum State {
    ALL,
    CURRENT,
    PAST,
    FUTURE,
    WAITING,
    REJECTED;

    public static State validateState(String value) {
        try {
            return State.valueOf(value);
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException("Unknown state"+ value);
        }
    }
}
