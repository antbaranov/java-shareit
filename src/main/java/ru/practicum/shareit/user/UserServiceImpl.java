package ru.practicum.shareit.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.exception.DuplicateEmailException;
import ru.practicum.shareit.user.exception.UserNotFoundException;
import ru.practicum.shareit.user.exception.ValidationException;
import ru.practicum.shareit.user.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto create(UserDto userDto
    ) throws ValidationException, DuplicateEmailException {
        //validator(userDto.getEmail());
        User user = UserMapper.toUser(userDto);
        user = userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto update(Long userId, UserDto userDto)
            throws UserNotFoundException, ValidationException, DuplicateEmailException {
        userDto.setId(userId);
        User repoUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        User user = UserMapper.matchUser(userDto, repoUser);
        user = userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto get(Long userId) throws UserNotFoundException {
        User repoUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
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

    private void validator(String email) throws DuplicateEmailException {
        List<User> users = userRepository.findAll();
        if (checker(users, email)) {
            log.warn("Пользователь с таким e-mail уже существует");
            throw new DuplicateEmailException("Пользователь с таким e-mail уже существует");
        }
    }

    private boolean checker(List<User> users, String email) {
        return users.stream()
                .anyMatch(repoUser -> repoUser.getEmail().equals(email));
    }
}
