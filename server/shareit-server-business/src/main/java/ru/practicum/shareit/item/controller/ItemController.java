package ru.practicum.shareit.item.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.item.comment.dto.CommentDto;
import ru.practicum.shareit.item.comment.service.CommentService;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.service.ItemService;
import ru.practicum.shareit.exception.PaginationException;
import static ru.practicum.shareit.utility.Variables.userIdHeader;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ItemController {
    private final ItemService itemService;
    private final CommentService commentService;

    @PostMapping
    public ItemDto create(@RequestHeader(userIdHeader) Long userId, @Valid @RequestBody ItemDto itemDto) {
        return itemService.create(userId, itemDto);
    }

    @PatchMapping("/{itemId}")
    public ItemDto update(
            @RequestHeader(userIdHeader) Long userId, @PathVariable Long itemId, @RequestBody ItemDto itemDto) {
        return itemService.update(userId, itemId, itemDto);
    }

    @GetMapping("/{itemId}")
    public ItemDto get(@RequestHeader(userIdHeader) Long userId, @PathVariable Long itemId) {
        return itemService.findById(userId, itemId);
    }

    //pagination
    @GetMapping
    public List<ItemDto> get(
            @RequestHeader(userIdHeader) Long userId,
            @RequestParam(defaultValue = "0") Long from,
            @RequestParam(defaultValue = "10") Long size) {
        return itemService.get(userId, from, size);
    }

    //pagination
    @GetMapping("/search")
    public List<ItemDto> search(
            @RequestHeader(userIdHeader) Long userId,
            @RequestParam String text,
            @RequestParam(defaultValue = "0") Long from,
            @RequestParam(defaultValue = "10") Long size
    ) throws PaginationException {
        return itemService.search(userId, text, from, size);
    }

    @PostMapping("/{itemId}/comment")
    public CommentDto comment(@RequestHeader(userIdHeader) Long userId, @PathVariable Long itemId,
                              @Valid @RequestBody CommentDto commentDto) {
        return commentService.comment(userId, itemId, commentDto);
    }

}
