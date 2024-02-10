package org.car_rantel.UI;

import org.car_rantel.dao.BookingDAO;
import org.car_rantel.domain.Customer;
import org.car_rantel.domain.Vehicle;
import org.car_rantel.service.BookingService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class MonthyReportUI {
    private final BookingService bookingService = new BookingService();

    public MonthyReportUI() {
        JFrame jFrame = new JFrame("Booking Panel");

        JPanel tblAndSearchPanel = new JPanel();
        tblAndSearchPanel.setBackground(Color.GRAY);
        tblAndSearchPanel.setLayout(new GridLayout(6,4));

        JLabel startDateLB = new JLabel("Start Date");
        JTextField startDate = new JTextField(10);
        JLabel endDateLB = new JLabel("End Date");
        JTextField endDate = new JTextField(10);
        JButton enterbtn = new JButton("Enter");

        tblAndSearchPanel.add(startDateLB);
        tblAndSearchPanel.add(startDate);
        tblAndSearchPanel.add(endDateLB);
        tblAndSearchPanel.add(endDate);
        tblAndSearchPanel.add(enterbtn);

        String[][] data = bookingService.getAllBookingForJTable();
        String[] column = {"CUSTOMER_ID", "VEHICLE_ID", "DATE", "PRICE", "STATUS"};
        DefaultTableModel dtm = new DefaultTableModel(data, column);
        JTable jt = new JTable(dtm);
        JScrollPane sp = new JScrollPane(jt);
        tblAndSearchPanel.add(sp);

        enterbtn.addActionListener(e->{
            String[][] searchData = bookingService.searchByDate(startDate.getText(), endDate.getText());
            DefaultTableModel searchDtm = new DefaultTableModel(searchData, column);
            jt.setModel(searchDtm);
        });

        jFrame.setLayout(new GridLayout(1, 2));
        jFrame.add(tblAndSearchPanel);

        jFrame.setSize(800, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}

