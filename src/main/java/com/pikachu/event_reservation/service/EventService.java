package com.pikachu.event_reservation.service;

import com.pikachu.event_reservation.model.Event;
import com.pikachu.event_reservation.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class EventService {
    private final EventRepository eventRepository;

    public Page<Event> search(String name, String location, LocalDateTime from, LocalDateTime to, Pageable pageable) {
        Specification<Event> specification = Specification.allOf();
        if (name != null)
            specification = specification.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        if (location != null)
            specification = specification.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("location"), "%" + location + "%"));
        if (from != null)
            specification = specification.and((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("eventDate"), from));
        if (to != null)
            specification = specification.and((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("eventDate"), to));

        return eventRepository.findAll(specification, pageable);
    }

    public Event getById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new NoSuchElementException("이벤트가 존재하지 않습니다."));
    }

    public Event create(Event event) {
        return eventRepository.save(event);
    }

    public Event update(Long id, Event event) {

    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
