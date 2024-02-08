package org.car_rantel.UI;

import org.car_rantel.dao.BookingDAO;
import org.car_rantel.dao.CustomerDAO;
import org.car_rantel.dao.VehicleDAO;
import org.car_rantel.domain.Customer;
import org.car_rantel.domain.Vehicle;
import org.car_rantel.service.BookingService;
import org.car_rantel.service.VehicleService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class BookingPanelUI {
    private final BookingService bookingService = new BookingService();
    VehicleDAO dao = new VehicleDAO();
    CustomerDAO cdao = new CustomerDAO();

    public BookingPanelUI() {
        JFrame jFrame = new JFrame("Booking Panel");

        JPanel tblAndSearchPanel = new JPanel();
        tblAndSearchPanel.setBackground(Color.GRAY);
        tblAndSearchPanel.setLayout(new BorderLayout());

        String[][] data = bookingService.getAllBookingForJTable();
        String[] column = {"CUSTOMER_ID", "VEHICLE_ID", "DATE", "PRICE", "STATUS"};
        DefaultTableModel dtm = new DefaultTableModel(data, column);
        JTable jt = new JTable(dtm);
        JScrollPane sp = new JScrollPane(jt);
        tblAndSearchPanel.add(sp, BorderLayout.CENTER);

        JTextField searchTF = new JTextField(30);
        searchTF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                String[][] searchData = bookingService.searchByStatus(searchTF.getText());
                DefaultTableModel searchDtm = new DefaultTableModel(searchData, column);
                jt.setModel(searchDtm);
            }
        });
        tblAndSearchPanel.add(searchTF, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 1));

        JButton addBookingButton = new JButton("ADD");
        addBookingButton.addActionListener(e -> {

            jFrame.dispose();
            new AddBookingUI();
        });
        buttonsPanel.add(addBookingButton);

        JButton editBookingButton = new JButton("EDIT");
        buttonsPanel.add(editBookingButton);

        JButton deleteBookingButton = new JButton("DELETE");
        deleteBookingButton.addActionListener(e -> {
            if (jt.getSelectedRow() > -1) {
                BookingDAO.deleteByIndex(jt.getSelectedRow());
                dtm.removeRow(jt.getSelectedRow());
            }
        });
        buttonsPanel.add(deleteBookingButton);

        JButton backButton = new JButton("BACK");
        backButton.addActionListener(e -> {

            jFrame.dispose();
            new HomeUI();
        });
        buttonsPanel.add(backButton);

        tblAndSearchPanel.add(buttonsPanel, BorderLayout.EAST);

        JPanel addPanel = new JPanel();
        addPanel.setLayout(new GridLayout(6, 1));


        JLabel selectVehicleLb = new JLabel("Select Vehicle");
        JComboBox<Vehicle> carDropdown = new JComboBox<>();
        List<Vehicle> vehicles = dao.getAll();
        for (Vehicle vehicle : vehicles) {
            carDropdown.addItem(vehicle);
        }

        JLabel selectCustomerLb = new JLabel("Select Customer");
        JComboBox<Customer> customerDropdown = new JComboBox<>();
        List<Customer> customers = cdao.getAll();
        for (Customer customer : customers) {
            customerDropdown.addItem(customer);
        }

        JLabel priceLb = new JLabel("Price");
        JTextField priceTextField = new JTextField();
        JLabel bookingdateLb = new JLabel("Set Booking Date");
        JTextField bookingDateTextField = new JTextField();

        JButton saveButton = new JButton("SAVE");
        saveButton.addActionListener(e -> {
            try {
                Vehicle selectedVehicle;
                Customer selectedCustomer;
                String price;
                String bookingDate;
                bookingService.save(
                selectedVehicle = (Vehicle) carDropdown.getSelectedItem(),
                selectedCustomer = (Customer) customerDropdown.getSelectedItem(),
                price = priceTextField.getText(),
                bookingDate = bookingDateTextField.getText());
                JOptionPane.showMessageDialog(jFrame, "Booking saved successfully");
                jFrame.dispose();
                new HomeUI();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(jFrame, "Error saving booking: " + ex.getMessage());
            }
        });

        addPanel.add(selectVehicleLb);
        addPanel.add(carDropdown);
        addPanel.add(selectCustomerLb);
        addPanel.add(customerDropdown);
        addPanel.add(priceLb);
        addPanel.add(priceTextField);
        addPanel.add(bookingdateLb);
        addPanel.add(bookingDateTextField);
        addPanel.add(saveButton);

        jFrame.setLayout(new GridLayout(1, 2));
        jFrame.add(tblAndSearchPanel);
        jFrame.add(addPanel);

        jFrame.setSize(1400, 700);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}

