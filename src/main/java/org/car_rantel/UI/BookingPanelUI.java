package org.car_rantel.UI;

import org.car_rantel.dao.BookingDAO;
import org.car_rantel.dao.CustomerDAO;
import org.car_rantel.service.BookingService;
import org.car_rantel.service.VehicleService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BookingPanelUI {
    private final BookingService bookingService = new BookingService();
    public BookingPanelUI(){
        JFrame jFrame = new JFrame("Booking Panel");

        JPanel tblAndSearchPanel = new JPanel();
        tblAndSearchPanel.setBackground(Color.GRAY);
        tblAndSearchPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JTextField searchTF = new JTextField(30);

        String[][] data = bookingService.getAllBookingForJTable();

        String column[]={"CUSTOMER_ID","VEHICLE_ID","DATE","PRICE","STATUS"};

        DefaultTableModel dtm = new DefaultTableModel(data,column);
        JTable jt=new JTable(dtm);
//        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);

        tblAndSearchPanel.add(searchTF);
        tblAndSearchPanel.add(sp);

        JPanel actionButtonPanel = new JPanel();
        actionButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JButton addBookingButton = new JButton("ADD");
        JButton editBookingButton = new JButton("EDIT");
        JButton deleteBookingButton = new JButton("DELETE");
        JButton back = new JButton("BACK");

        actionButtonPanel.add(addBookingButton);
        actionButtonPanel.add(editBookingButton);
        actionButtonPanel.add(deleteBookingButton);
        actionButtonPanel.add(back);

        addBookingButton.addActionListener(e->{
            jFrame.dispose();
            new AddBookingUI();
        });

        searchTF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String[][] data = bookingService.searchByStatus(searchTF.getText());
                DefaultTableModel dtm = new DefaultTableModel(data,column);
                jt.setModel(dtm);
            }
        });

        deleteBookingButton.addActionListener(e ->{
            if (jt.getSelectedRow() > -1){
                BookingDAO.deleteByIndex(jt.getSelectedRow());
                dtm.removeRow(jt.getSelectedRow());
            }
        });

        back.addActionListener(e->{
            jFrame.dispose();
            new HomeUI();
        });


        jFrame.setLayout(new GridLayout(1,2,150,5));

        jFrame.add(tblAndSearchPanel);
        jFrame.add(actionButtonPanel);

        jFrame.setSize(1400, 700);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
