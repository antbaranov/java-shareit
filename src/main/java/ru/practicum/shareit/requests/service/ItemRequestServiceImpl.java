package ru.practicum.shareit.requests.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.ItemRequestNotFoundException;
import ru.practicum.shareit.exception.PaginationException;
import ru.practicum.shareit.exception.UserNotFoundException;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.mapper.ItemMapper;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.item.repository.ItemRepository;
import ru.practicum.shareit.requests.dto.ItemRequestDto;
import ru.practicum.shareit.requests.mapper.ItemRequestMapper;
import ru.practicum.shareit.requests.model.ItemRequest;
import ru.practicum.shareit.requests.pagerequestmanager.PageRequestManager;
import ru.practicum.shareit.requests.repository.ItemRequestRepository;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemRequestServiceImpl implements ItemRequestService {

    private final ItemRequestRepository itemRequestRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public ItemRequestDto create(Long userId, ItemRequestDto itemRequestDto) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("user not found"));
        itemRequestDto.setCreated(LocalDateTime.now());
        ItemRequest itemRequest = ItemRequestMapper.toItemRequest(itemRequestDto, user);
        itemRequest = itemRequestRepository.save(itemRequest);
        return ItemRequestMapper.toItemRequestDto(itemRequest);
    }

    // Получить список своих запросов
    @Override
    public List<ItemRequestDto> get(Long userId) {

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("user not found"));
        List<ItemRequest> itemRequests = itemRequestRepository.findAllByRequesterIdOrderByCreatedDesc(
            userId);
        if (itemRequests.isEmpty()) {
            return Collections.emptyList();
        }
        List<ItemRequestDto> itemRequestDtos = itemRequests.stream()
            .map(ItemRequestMapper::toItemRequestDto)
            .collect(Collectors.toList());

        List<Long> requestIdList = itemRequestDtos.stream()
            .map(ItemRequestDto::getId)
            .collect(Collectors.toList());
        List<Item> items = itemRepository.findAllByRequestIdIn(requestIdList);

        for (ItemRequestDto itemRequestDto : itemRequestDtos) {
            List<Item> requestItems = items.stream()
                .filter(item -> item.getRequest().getId().equals(itemRequestDto.getId()))
                .collect(Collectors.toList());
            if (!requestItems.isEmpty()) {
                List<ItemDto> itemDtos = requestItems.stream()
                    .map(ItemMapper::toItemDto)
                    .collect(Collectors.toList());
                itemRequestDto.setItems(itemDtos);
            }
        }
        return itemRequestDtos;
    }

    // Список запросов созданных другими пользователями
    // от наиболее новых к наиболее старым
    // результаты постранично
    // from - индекс первого элемента
    // size - количество элементов для отображения

    @Override
    public List<ItemRequestDto> get(Long userId, Long from, Long size) throws PaginationException {

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("user not found"));

        PageRequest pageRequest = PageRequestManager.form(
            from.intValue(), size.intValue(), Sort.Direction.DESC, "created");
        List<ItemRequest> itemRequests = itemRequestRepository.findAllByRequesterIdIsNot(userId,
            pageRequest);

        List<ItemRequestDto> itemRequestDtos = itemRequests.stream()
            .map(ItemRequestMapper::toItemRequestDto)
            .collect(Collectors.toList());

        List<Long> requestIdList = itemRequestDtos.stream()
            .map(ItemRequestDto::getId)
            .collect(Collectors.toList());
        List<Item> items = itemRepository.findAllByRequestIdIn(requestIdList);

        for (ItemRequestDto itemRequestDto : itemRequestDtos) {
            List<Item> requestItems = items.stream()
                .filter(item -> item.getRequest().getId().equals(itemRequestDto.getId()))
                .collect(Collectors.toList());
            if (!requestItems.isEmpty()) {
                List<ItemDto> itemDtos = requestItems.stream()
                    .map(ItemMapper::toItemDto)
                    .collect(Collectors.toList());
                itemRequestDto.setItems(itemDtos);
            }
        }
        return itemRequestDtos;
    }


    // Получить запрос по id (любой пользователь любой запрос)
    @Override
    public ItemRequestDto get(Long userId, Long requestId) {

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("user not found"));
        ItemRequest itemRequest = itemRequestRepository.findItemRequestById(requestId)
            .orElseThrow(() -> new ItemRequestNotFoundException("request not found"));
        ItemRequestDto itemRequestDto = ItemRequestMapper.toItemRequestDto(itemRequest);

        List<Item> items = itemRepository.findAllByRequestId(itemRequestDto.getId());
        if (!items.isEmpty()) {
            List<ItemDto> itemDtos = items.stream()
                .map(ItemMapper::toItemDto)
                .collect(Collectors.toList());
            itemRequestDto.setItems(itemDtos);
        }
        return itemRequestDto;
    }
}
