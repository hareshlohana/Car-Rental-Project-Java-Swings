package org.car_rantel.service;

import org.car_rantel.dao.BookingDAO;
import org.car_rantel.dao.CustomerDAO;
import org.car_rantel.domain.Booking;
import org.car_rantel.domain.Customer;
import org.car_rantel.domain.Vehicle;

import java.time.LocalDate;
import java.util.List;

public class BookingService {
    BookingDAO dao = new BookingDAO();


    public String[][] searchByStatus(String status){

        List<Booking> bookingList = dao.getByStatus(status);
        String[][] data = new String[bookingList.size()][5];
        return transformToJTable(bookingList, 5);
    }
    public String[][] getAllBookingForJTable(){

        List<Booking> bookingList = dao.getAll();
        String[][] data = new String[bookingList.size()][5];

        for (int i = 0; i < bookingList.size(); i++) {
            data[i][0] = String.valueOf(bookingList.get(i).getCid());
            data[i][1] = String.valueOf(bookingList.get(i).getVid());
            data[i][2] = String.valueOf(bookingList.get(i).getBooking_date());
            data[i][3] = String.valueOf(bookingList.get(i).getPrice());
            data[i][4] = bookingList.get(i).getBooking_status();
        }
        System.out.println(data);
        return data;
    }

    public String[][] transformToJTable(List<Booking> bookingList, int columnsize){
        String[][] data = new String[bookingList.size()][5];

        for (int i = 0; i < bookingList.size(); i++) {
            data[i][0] = String.valueOf(bookingList.get(i).getCid());
            data[i][1] = String.valueOf(bookingList.get(i).getVid());
            data[i][2] = String.valueOf(bookingList.get(i).getBooking_date());
            data[i][3] = String.valueOf(bookingList.get(i).getPrice());
            data[i][4] = bookingList.get(i).getBooking_status();
        }
        return data;
    }

    public void save(String cid, String vid, String date, String price, String status) {
        Booking booking = Booking.builder()
                .cid(Long.valueOf(cid))
                .vid(Long.valueOf(vid))
                .booking_date(LocalDate.parse(date))
                .price(Double.valueOf(price))
                .booking_status(status)
                .build();

        dao.insert(booking);
    }

    public void save(Vehicle vehicle, Customer customer, String price, String date) {
        Booking booking = Booking.builder()
                .cid(Long.valueOf(customer.getId()))
                .vid(Long.valueOf(vehicle.getId()))
                .booking_date(LocalDate.parse(date))
                .price(Double.valueOf(price))
                .build();

        dao.insert(booking);
    }
}
