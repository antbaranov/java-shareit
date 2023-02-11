package ru.practicum.shareit.request.model;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemRequest {
private Long id;
private String description;

}
