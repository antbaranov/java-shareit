package ru.practicum.shareit.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.DataExistException;
import ru.practicum.shareit.exception.DuplicateEmailException;
import ru.practicum.shareit.exception.ObjectNotFoundException;
import ru.practicum.shareit.user.UserRepository;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.mapper.UserMapper;
import ru.practicum.shareit.user.model.User;

import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto
    ) throws DuplicateEmailException {

            User user = UserMapper.toUser(userDto);
            user = userRepository.save(user);
            log.info("Добавлен пользователь с id: {} с email: {}", user.getId(), user.getEmail());
            return UserMapper.toUserDto(user);

    }

    @Override
    public UserDto update(Long userId, UserDto userDto)
            throws ObjectNotFoundException, ValidationException, DuplicateEmailException {
        userDto.setId(userId);
        User repoUser = userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException("user not found"));
        User user = UserMapper.matchUser(userDto, repoUser);
        user = userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto get(Long userId) throws ObjectNotFoundException {
        User repoUser = userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException("user not found"));
        return UserMapper.toUserDto(repoUser);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> get() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }
}