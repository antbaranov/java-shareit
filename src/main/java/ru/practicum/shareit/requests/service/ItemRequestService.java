package ru.practicum.shareit.requests.service;

import ru.practicum.shareit.requests.dto.ItemRequestDto;

import java.util.List;

public interface ItemRequestService {
    ItemRequestDto create(Long userId, ItemRequestDto itemRequestDto);

    List<ItemRequestDto> get(Long userId);

    List<ItemRequestDto> get(Long userId, Long from, Long size);

    ItemRequestDto get(Long userId, Long requestId);
}
