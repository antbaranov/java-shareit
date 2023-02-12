package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;

class DuplicateEmailExceptionTest {

    @Test
    void setDuplicateEmailExceptionTest() {
        DuplicateEmailException duplicateEmailException = new DuplicateEmailException("test");
    }

}