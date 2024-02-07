package org.car_rantel.mapper;

import org.car_rantel.domain.Booking;
import org.car_rantel.domain.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingMapper implements Imapper<Booking>{

    private static String ID = "id";
    private static String CID = "cid";
    private static String VID = "vid";
    private static String BOOKING_DATE = "booking_date";
    private static String PRICE = "price";
    private static String BOOKING_STATUS = "booking_status";
    @Override
    public List<Booking> resultSetToList(ResultSet rs) throws SQLException {
        List<Booking> bookingList = new ArrayList<Booking>();
        while (rs.next()){
            Booking booking = Booking.builder()
                    .id((long) rs.getInt(ID))
                    .cid(Long.valueOf(rs.getString(CID)))
                    .vid(Long.valueOf(rs.getString(VID)))
                    .booking_date(LocalDate.parse(rs.getString(BOOKING_DATE)))
                    .booking_status(rs.getString(BOOKING_STATUS))
                    .build();
            bookingList.add(booking);
        }
        return bookingList;
    }

    @Override
    public Booking resultSetToObject(ResultSet rs) throws SQLException {
        if (rs.next()){
            return Booking.builder()
                    .id((long) rs.getInt(ID))
                    .cid(Long.valueOf(rs.getString(CID)))
                    .vid(Long.valueOf(rs.getString(VID)))
                    .booking_date(LocalDate.parse(rs.getString(BOOKING_DATE)))
                    .booking_status(rs.getString(BOOKING_STATUS))
                    .build();
        }
        return null;
    }
}
