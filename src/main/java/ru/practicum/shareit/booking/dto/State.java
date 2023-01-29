package ru.practicum.shareit.booking.dto;

import ru.practicum.shareit.booking.exception.InvalidStatusException;
import ru.practicum.shareit.exception.ArgumentException;

public enum State {
    ALL,
    CURRENT,
    PAST,
    FUTURE,
    WAITING,
    REJECTED;

    public static State validateState(String value) {
        State state = State.ALL;
        try {
            return State.valueOf(value);
        } catch (Exception exception) {
            throw new ArgumentException("Unknown state: " + value);
        }
    }
}
