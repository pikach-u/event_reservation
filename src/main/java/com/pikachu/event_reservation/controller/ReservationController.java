package com.pikachu.event_reservation.controller;

import com.pikachu.event_reservation.dto.ReservationDto;
import com.pikachu.event_reservation.model.Reservation;
import com.pikachu.event_reservation.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/api/events/{eventId}/reservations")
    public Reservation add(@PathVariable Long eventId, @Valid @RequestBody ReservationDto reservationDto) {
        return reservationService.create(eventId, reservationDto);
    }
}
