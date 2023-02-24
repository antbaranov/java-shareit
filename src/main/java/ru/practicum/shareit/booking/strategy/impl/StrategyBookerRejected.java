package ru.practicum.shareit.booking.strategy.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.booking.model.Booking;
import ru.practicum.shareit.booking.model.Status;
import ru.practicum.shareit.booking.repository.BookingRepository;
import ru.practicum.shareit.booking.strategy.BookingStateFetchStrategyForBooker;
import ru.practicum.shareit.booking.strategy.StrategyName;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StrategyBookerRejected implements BookingStateFetchStrategyForBooker {

    private final BookingRepository bookingRepository;

    @Override
    public List<Booking> fetch(Long userId, PageRequest pageRequest) {
        return bookingRepository.findAllByBookerIdAndStatus(userId, Status.REJECTED, pageRequest);
    }

    @Override
    public StrategyName getStrategy() {
        return StrategyName.REJECTED;
    }
}
