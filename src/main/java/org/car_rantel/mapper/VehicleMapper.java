package org.car_rantel.mapper;

import org.car_rantel.domain.Customer;
import org.car_rantel.domain.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleMapper implements Imapper<Vehicle> {

    private static String ID = "id";
    private static String NAME = "v_name";
    private static String MODEL = "model";
    private static String BRAND = "brand";
    private static String COLOR = "color";
    private static String OWNER_ID = "owner_id";

    @Override
    public List<Vehicle> resultSetToList(ResultSet rs) throws SQLException {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        while (rs.next()){
            Vehicle vehicle = Vehicle.builder()
                    .id((long) rs.getInt(ID))
                    .v_name(rs.getString(NAME))
                    .model(rs.getString(MODEL))
                    .brand(rs.getString(BRAND))
                    .color(rs.getString(COLOR))
                    .owner_id(Long.valueOf(rs.getString(OWNER_ID)))
                    .build();
            vehicleList.add(vehicle);
        }
        return vehicleList;
    }

    @Override
    public Vehicle resultSetToObject(ResultSet rs) throws SQLException {
        if (rs.next()){
            return Vehicle.builder()
                    .id((long) rs.getInt(ID))
                    .v_name(rs.getString(NAME))
                    .model(rs.getString(MODEL))
                    .brand(rs.getString(BRAND))
                    .color(rs.getString(COLOR))
                    .owner_id(Long.valueOf(rs.getString(OWNER_ID)))
                    .build();
        }
        return null;
    }
}
