package org.car_rantel.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Vehicle {
    private Long id;
    private String v_name;
    private String model;
    private String brand;
    private String color;
    private Long owner_id;
}
