package org.car_rantel.UI;

import org.car_rantel.service.BookingService;
import org.car_rantel.service.CustomerService;

import javax.swing.*;
import java.awt.*;

public class AddBookingUI {
    private final BookingService bookingService = new BookingService();
    public AddBookingUI(){
        JFrame frame = new JFrame("NEW BOOKING ");
        frame.setLayout(new GridLayout(6,4,10,10));

        JLabel cidLb = new JLabel("CUSTOMER_ID");
        JTextField cidTf = new JTextField(20);

        JLabel vidLb = new JLabel("VEHICLE_ID");
        JTextField vidTf = new JTextField(20);

        JLabel dateLb = new JLabel("DATE");
        JTextField dateTf = new JTextField(20);

        JLabel priceLb = new JLabel("PRICE");
        JTextField priceTf = new JTextField(20);

        JLabel statusLb = new JLabel("STATUS");
        JTextField statusTf = new JTextField(20);

        JButton back = new JButton("BACK");
        JButton save = new JButton("SAVE");

        frame.add(cidLb);
        frame.add(cidTf);
        frame.add(vidLb);
        frame.add(vidTf);
        frame.add(dateLb);
        frame.add(dateTf);
        frame.add(priceLb);
        frame.add(priceTf);
        frame.add(statusLb);
        frame.add(statusTf);
        frame.add(save);
        frame.add(back);

        back.addActionListener(e->{
            frame.dispose();
            new BookingPanelUI();
        });

        save.addActionListener(e->{

            try {
                bookingService.save(cidTf.getText(), vidTf.getText(),
                        dateTf.getText(), priceTf.getText(), statusTf.getText());
                frame.dispose();
                new BookingPanelUI();

            }catch (Exception ex){
//                JOptionPane.showMessageDialog(frame,"Unable to save");
                throw new RuntimeException(ex);
            }

        });

        frame.setSize(1400,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
