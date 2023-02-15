package ru.practicum.shareit.requests.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.requests.dto.ItemRequestDto;
import ru.practicum.shareit.requests.model.ItemRequest;
import ru.practicum.shareit.user.model.User;

import java.util.Collections;
import java.util.List;

//@Mapper(componentModel = "spring")
public class ItemRequestMapper {

    /*@Mapping(target = "id", source = "itemRequest.id")
    @Mapping(target = "requester", source = "itemRequest.requester.id")
    @Mapping(target = "items", expression = "java(setItems())")
    ItemRequestDto toItemRequestDto(ItemRequest itemRequest);


    @Mapping(target = "id", source = "itemRequestDto.id")
    @Mapping(target = "requester", source = "user")
    ItemRequest toItemRequest(ItemRequestDto itemRequestDto, User user);

    default List<ItemDto> setItems() {
        return Collections.emptyList();
    }
*/
    public static ItemRequestDto toItemRequestDto(ItemRequest itemRequest) {
        return ItemRequestDto.builder()
                .id(itemRequest.getId())
                .description(itemRequest.getDescription())
                .requester(itemRequest.getRequester().getId())
                .created(itemRequest.getCreated())
                .items(Collections.emptyList())
                .build();
    }

    public static ItemRequest toItemRequest(ItemRequestDto itemRequestDto, User user) {
        return ItemRequest.builder()
                .id(itemRequestDto.getId())
                .description(itemRequestDto.getDescription())
                .requester(user)
                .created(itemRequestDto.getCreated())
                .build();

    }
}
