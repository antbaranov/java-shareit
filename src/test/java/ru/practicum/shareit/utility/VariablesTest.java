package ru.practicum.shareit.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.practicum.shareit.utility.Variables.userIdHeader;

class VariablesTest {
    @Test
    void userIdHeaderTest() {
        Assertions.assertTrue(userIdHeader.equals("X-Sharer-User-Id"));
    }
}