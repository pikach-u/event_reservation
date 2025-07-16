package com.pikachu.event_reservation.service;

import com.pikachu.event_reservation.dto.ReservationDto;
import com.pikachu.event_reservation.model.Event;
import com.pikachu.event_reservation.model.Reservation;
import com.pikachu.event_reservation.repository.EventRepository;
import com.pikachu.event_reservation.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final EventRepository eventRepository;

    public Reservation create(Long eventId, ReservationDto reservationDto) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new NoSuchElementException("이벤트가 존재하지 않습니다."));

        Reservation reservation = new Reservation();
        reservation.setEvent(event);
        reservation.setAttendeeName(reservationDto.getAttendeeName());
        reservation.setSeat(reservationDto.getSeats());

        return reservationRepository.save(reservation);
    }
}
