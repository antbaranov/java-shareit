package ru.practicum.shareit.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.practicum.shareit.utility.Variables.X_SHARER_USER_ID;

class VariablesTest {
    @Test
    void userIdHeaderTest() {

        Assertions.assertTrue(X_SHARER_USER_ID.equals("X-Sharer-User-Id"));
    }
}