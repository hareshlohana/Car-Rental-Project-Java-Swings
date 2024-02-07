package org.car_rantel.domain;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Customer {

    private Long id;
    private String name;
    private String contact;
    private String cnic;
    private String address;
    private String ref_number;

}