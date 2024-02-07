package org.car_rantel.dao;

import org.car_rantel.domain.Booking;
import org.car_rantel.domain.Customer;
import org.car_rantel.mapper.BookingMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.car_rantel.dao.SqlQueryConstant.*;

public class BookingDAO  extends BaseDAO implements ICrud<Booking>{

    private final BookingMapper bookingMapper = new BookingMapper();
    @Override
    public void insert(Booking obj) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO_BOOKING);
            ps.setString(1, String.valueOf(obj.getCid()));
            ps.setString(2, String.valueOf(obj.getVid()));
            ps.setString(3, String.valueOf(obj.getBooking_date()));
            ps.setString(4, String.valueOf(obj.getPrice()));
            ps.setString(5, obj.getBooking_status());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Booking> getAll() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(Get_All_BOOKING);
            return bookingMapper.resultSetToList(rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Booking getById(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(Get_BOOKING_BY_ID);
            ps.setInt(1, id.intValue());
            ResultSet rs = ps.executeQuery();
            return bookingMapper.resultSetToObject(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Booking> getByStatus(String status) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from booking where booking_status like '%"+status+"%'");
            ResultSet rs = ps.executeQuery();
            return bookingMapper.resultSetToList(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Booking obj, Long id) {

    }

    @Override
    public List<Customer> deleteByID(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_BOOKING_BY_ID);
            ps.setInt(1,id.intValue());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void deleteByIndex(Integer index) {
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_CUSTOMER_BY_ID);
            ps.setInt(1,index);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
