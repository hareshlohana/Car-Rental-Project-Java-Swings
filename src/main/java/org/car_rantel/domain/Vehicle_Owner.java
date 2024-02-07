package org.car_rantel.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Vehicle_Owner {
    private Long id;
    private String owner_name;
    private String owner_number;
    private String cnic;
    private String address;
    private Float commission;
}
