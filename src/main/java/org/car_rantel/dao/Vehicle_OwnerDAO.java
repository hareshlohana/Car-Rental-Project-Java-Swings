package org.car_rantel.dao;

import org.car_rantel.domain.Customer;
import org.car_rantel.domain.Vehicle_Owner;
import org.car_rantel.mapper.VehicleOwnerMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.car_rantel.dao.SqlQueryConstant.*;

public class Vehicle_OwnerDAO extends BaseDAO implements ICrud<Vehicle_Owner>{

    private final VehicleOwnerMapper vehicleOwnerMapper = new VehicleOwnerMapper();
    @Override
    public void insert(Vehicle_Owner obj) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_VEHICLE_OWNER);
            ps.setString(1, obj.getOwner_name());
            ps.setString(2, obj.getOwner_number());
            ps.setString(3, obj.getCnic());
            ps.setString(4, obj.getAddress());
            ps.setFloat(5, obj.getCommission());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle_Owner> getAll() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(Get_All_VEHICLE_OWNER);
            return vehicleOwnerMapper.resultSetToList(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle_Owner getById(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(Get_VEHICLE_OWNER_BY_ID);
            ps.setInt(1, id.intValue());
            ResultSet rs = ps.executeQuery();
            return vehicleOwnerMapper.resultSetToObject(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Vehicle_Owner> getByName(String name) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from vehicle_owner where owner_name like '%"+name+"%'");
            ResultSet rs = ps.executeQuery();
            return vehicleOwnerMapper.resultSetToList(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Vehicle_Owner obj, Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_VEHICLE_OWNER_BY_ID);
            ps.setString(1,obj.getOwner_name());
            ps.setInt(2,id.intValue());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> deleteByID(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_VEHICLE_OWNER_BY_ID);
            ps.setInt(1,id.intValue());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void deleteByIndex(Integer index) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM vehicle_owner where id ="+index+"");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
