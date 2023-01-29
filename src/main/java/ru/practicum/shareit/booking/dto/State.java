package ru.practicum.shareit.booking.dto;

import ru.practicum.shareit.booking.exception.ArgumentException;
import ru.practicum.shareit.booking.exception.InvalidStatusException;

public enum State {
    ALL,
    CURRENT,
    PAST,
    FUTURE,
    WAITING,
    REJECTED;

    public static State validateState(String value) throws InvalidStatusException {
        State state = State.ALL;
        try {
            return State.valueOf(value);
        } catch (InvalidStatusException exception) {
            throw new ArgumentException("Unknown state: " + value);
        }
    }
}
