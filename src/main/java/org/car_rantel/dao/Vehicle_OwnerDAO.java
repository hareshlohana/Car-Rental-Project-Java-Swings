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

    private static final VehicleOwnerMapper vehicleOwnerMapper = new VehicleOwnerMapper();

    public static Vehicle_Owner getByIndex(int index) {
        try {
            PreparedStatement ps = conn.prepareStatement("WITH IndexedRows AS (SELECT *, ROW_NUMBER() OVER (ORDER BY id) AS row_num FROM vehicle_owner) SELECT * FROM IndexedRows WHERE row_num = "+index+"+1");
            ResultSet rs = ps.executeQuery();
            return vehicleOwnerMapper.resultSetToObject(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
    public void update(Vehicle_Owner obj,Integer index) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE vehicle_owner SET owner_name = ?, owner_number = ?, cnic = ?, address = ?, commission = ? where id ="+index+"+1");
            ps.setString(1,obj.getOwner_name());
            ps.setString(2,obj.getOwner_number());
            ps.setString(3,obj.getCnic());
            ps.setString(4,obj.getAddress());
            ps.setString(5, String.valueOf(obj.getCommission()));
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
