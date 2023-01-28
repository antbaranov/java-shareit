package ru.practicum.shareit.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.shareit.item.model.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByOwner_Id(Long id);

    @Query("FROM Item AS it " +
            "WHERE it.available = TRUE AND " +
            "(upper(it.name) " +
            "LIKE upper(concat('%',?1,'%')) OR upper(it.description) " +
            "LIKE upper(concat('%',?1,'%')))")
    List<Item> searchAvailableByText(String text);
}
