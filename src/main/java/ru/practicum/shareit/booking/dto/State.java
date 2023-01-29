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
        } catch (Exception exception) {
            throw new NullPointerException("Unknown state"+ value);
        }
    }
}
