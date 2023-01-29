package ru.practicum.shareit.booking.dto;

import ru.practicum.shareit.booking.exception.InvalidStatusException;

public enum State {
    ALL,
    CURRENT,
    PAST,
    FUTURE,
    WAITING,
    REJECTED;

    public static State validateState(String value) throws InvalidStatusException  {
        State state = State.ALL;
        try {
            state = State.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidStatusException("Unknown state: " + value);
        }
        return state;
    }
}
