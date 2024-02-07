package org.car_rantel.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Booking {
    private Long id;
    private Long cid;
    private Long vid;
    private LocalDate booking_date;
    private Double price;
    private String booking_status;
}
