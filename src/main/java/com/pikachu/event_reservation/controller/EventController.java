package com.pikachu.event_reservation.controller;

import com.pikachu.event_reservation.dto.EventDto;
import com.pikachu.event_reservation.model.Event;
import com.pikachu.event_reservation.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    public Event create(@Valid @RequestBody EventDto eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setEventData(eventDto.getEventDate());
        event.setLocation(eventDto.getLocation());

        return eventService.create(event);
    }
}
