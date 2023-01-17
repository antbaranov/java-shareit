package ru.practicum.shareit.user.mapper;

import org.mapstruct.Mapper;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.model.User;


/*public class UserMapper {
    public static User toUser(UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getName(),
                userDto.getEmail());
    }
}*/
@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto userDto);
}

