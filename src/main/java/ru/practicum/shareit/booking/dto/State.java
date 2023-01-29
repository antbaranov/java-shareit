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
        State state = State.ALL;
        try {
            state = State.valueOf(value);
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException("Unknown state"+ value);
        }
        return state;
    }
}
