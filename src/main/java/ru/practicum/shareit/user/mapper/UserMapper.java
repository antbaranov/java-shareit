package ru.practicum.shareit.user.mapper;

import org.mapstruct.Mapper;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUseDto(User user);

    User toUser(UserDto userDto);
}
/*
public class UserMapper {
    public static User toUser(UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getName(),
                userDto.getEmail());
    }
    }*/

