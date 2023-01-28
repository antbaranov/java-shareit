package ru.practicum.shareit.user.service;

import ru.practicum.shareit.exception.ObjectNotFoundException;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.exception.DuplicateEmailException;

import javax.validation.ValidationException;
import java.util.List;

public interface UserService {

    UserDto create(UserDto userDto) throws DuplicateEmailException;

    UserDto update(Long userId, UserDto userDto) throws ObjectNotFoundException, ValidationException, DuplicateEmailException;

    UserDto get(Long userId);

    void delete(Long userId);

    List<UserDto> get();
}