package ru.practicum.shareit.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerPagination {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public PaginationException.ErrorResponse handleInvalidStatusException(InvalidStatusException exception) {
        return new PaginationException.ErrorResponse(exception.getMessage());
    }
}
