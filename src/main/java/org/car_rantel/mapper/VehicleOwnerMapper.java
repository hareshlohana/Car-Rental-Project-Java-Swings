package org.car_rantel.mapper;

import org.car_rantel.domain.Booking;
import org.car_rantel.domain.Vehicle;
import org.car_rantel.domain.Vehicle_Owner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleOwnerMapper implements Imapper<Vehicle_Owner>{

    private static String ID = "id";
    private static String OWNER_NAME = "owner_name";
    private static String OWNER_NUMBER = "owner_number";
    private static String CNIC = "cnic";
    private static String ADDRESS = "address";
    private static String COMMISSION = "commission";

    @Override
    public List<Vehicle_Owner> resultSetToList(ResultSet rs) throws SQLException {
        List<Vehicle_Owner> vehicleOwnersList = new ArrayList<Vehicle_Owner>();
        while (rs.next()){
            Vehicle_Owner vehicle_owner = Vehicle_Owner.builder()
                    .id((long) rs.getInt(ID))
                    .owner_name(rs.getString(OWNER_NAME))
                    .owner_number(rs.getString(OWNER_NUMBER))
                    .cnic(rs.getString(CNIC))
                    .address(rs.getString(ADDRESS))
                    .commission(rs.getFloat(COMMISSION))
                    .build();
            vehicleOwnersList.add(vehicle_owner);
        }
        return vehicleOwnersList;
    }

    @Override
    public Vehicle_Owner resultSetToObject(ResultSet rs) throws SQLException {
        if (rs.next()){
            return Vehicle_Owner.builder()
                    .id((long) rs.getInt(ID))
                    .owner_name(rs.getString(OWNER_NAME))
                    .owner_number(rs.getString(OWNER_NUMBER))
                    .cnic(rs.getString(CNIC))
                    .address(rs.getString(ADDRESS))
                    .commission(rs.getFloat(COMMISSION))
                    .build();
        }
        return null;
    }
}
