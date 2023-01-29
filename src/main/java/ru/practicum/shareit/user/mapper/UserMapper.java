package ru.practicum.shareit.user.mapper;

import org.mapstruct.Mapper;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.dto.UserInfoDto;
import ru.practicum.shareit.user.model.User;



@Mapper(componentModel = "spring")
public interface UserMapper {
    UserInfoDto toUserInfoDto(User user);

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

    User matchUser(UserDto userDto, User user);
}




/*
public class UserMapper {

    public static UserInfoDto toUserInfoDto(User user) {
        return UserInfoDto.builder()
                .id(user.getId())
                .build();
    }

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User toUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
    }

    public static User matchUser(UserDto userDto, User user) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName() == null ? user.getName() : userDto.getName())
                .email(userDto.getEmail() == null ? user.getEmail() : userDto.getEmail())
                .build();
    }


}
*/