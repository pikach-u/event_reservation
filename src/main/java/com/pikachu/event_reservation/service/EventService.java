package com.pikachu.event_reservation.service;

import com.pikachu.event_reservation.model.Event;
import com.pikachu.event_reservation.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class EventService {
    private final EventRepository eventRepository;

    public Event create(Event event){
        return eventRepository.save(event);
    }
}
