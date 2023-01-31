package ru.practicum.shareit.item.service;

import ru.practicum.shareit.item.dto.ItemDto;

import java.util.List;

public interface ItemService {

    ItemDto create(Long userId, ItemDto itemDto);

    ItemDto update(Long userId, Long itemId, ItemDto itemDto);

    ItemDto get(Long userId, Long itemId);

    List<ItemDto> get(Long userId);

    List<ItemDto> search(Long userId, String text);
}
