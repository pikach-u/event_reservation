package com.pikachu.event_reservation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    @NotBlank(message = "예약자 성함을 입력해주세요.")
    private String attendeeName;

    @Min(1)
    @NotNull(message = "예약하실 좌석 수를 입력해주세요.")
    private Integer seats;
}
