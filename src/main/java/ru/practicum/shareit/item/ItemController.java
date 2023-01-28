package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.item.exception.InvalidCommentException;
import ru.practicum.shareit.item.exception.ItemNotFoundException;
import ru.practicum.shareit.user.exception.UserNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final String X_SHARER_USER_ID = "X-Sharer-User-Id";
    private final ItemService itemService;

    @PostMapping
    public ItemDto create(@RequestHeader(X_SHARER_USER_ID) Long userId, @Valid @RequestBody ItemDto itemDto)
            throws UserNotFoundException {
        return itemService.create(userId, itemDto);
    }

    @PatchMapping("/{itemId}")
    public ItemDto update(
            @RequestHeader(X_SHARER_USER_ID) Long userId, @PathVariable Long itemId, @RequestBody ItemDto itemDto)
            throws ItemNotFoundException, UserNotFoundException {
        return itemService.update(userId, itemId, itemDto);
    }

    @GetMapping("/{itemId}")
    public ItemDto get(@RequestHeader(X_SHARER_USER_ID) Long userId, @PathVariable Long itemId)
            throws ItemNotFoundException, UserNotFoundException {
        return itemService.get(userId, itemId);
    }

    @GetMapping
    public List<ItemDto> get(@RequestHeader(X_SHARER_USER_ID) Long userId) throws UserNotFoundException {
        return itemService.get(userId);
    }

    @GetMapping("/search")
    public List<ItemDto> search(
            @RequestHeader(X_SHARER_USER_ID) Long userId,
            @RequestParam String text
    ) throws UserNotFoundException {
        return itemService.search(userId, text);
    }

    @PostMapping("/{itemId}/comment")
    public CommentDto comment(
            @RequestHeader(X_SHARER_USER_ID) Long userId,
            @PathVariable Long itemId,
            @Valid @RequestBody CommentDto commentDto
    ) throws UserNotFoundException, InvalidCommentException, ItemNotFoundException {
        return itemService.comment(userId, itemId, commentDto);
    }

}
