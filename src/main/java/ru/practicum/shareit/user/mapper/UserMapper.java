package ru.practicum.shareit.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.model.User;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

    @Mapping(target = "id", source = "userDto.id")
    @Mapping(target = "name", source = "userDto.name")
    @Mapping(target = "email", source = "userDto.email")
    User matchUser(UserDto userDto, User user);

    /*static User matchUser(UserDto userDto, User user) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName() == null ? user.getName() : userDto.getName())
                .email(userDto.getEmail() == null ? user.getEmail() : userDto.getEmail())
                .build();
    }*/
}