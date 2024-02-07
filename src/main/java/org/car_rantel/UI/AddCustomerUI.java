package org.car_rantel.UI;

import org.car_rantel.dao.CustomerDAO;
import org.car_rantel.domain.Customer;
import org.car_rantel.service.CustomerService;

import javax.swing.*;
import java.awt.*;

public class AddCustomerUI {
    private final CustomerService customerService = new CustomerService();
    public AddCustomerUI(){
        JFrame frame = new JFrame("ADD CUSTOMER ");
        frame.setLayout(new GridLayout(6,4,10,10));

        JLabel nameLb = new JLabel("NAME");
        JTextField nameTf = new JTextField(20);

        JLabel numberLb = new JLabel("NUMBER");
        JTextField numberTf = new JTextField(20);

        JLabel cnicLb = new JLabel("CNIC");
        JTextField cnicTf = new JTextField(20);

        JLabel addressLb = new JLabel("ADDRESS");
        JTextField addressTf = new JTextField(20);

        JLabel refLb = new JLabel("REF_NUMBER");
        JTextField refTf = new JTextField(20);

        JButton back = new JButton("BACK");
        JButton save = new JButton("SAVE");

        frame.add(nameLb);
        frame.add(nameTf);
        frame.add(numberLb);
        frame.add(numberTf);
        frame.add(cnicLb);
        frame.add(cnicTf);
        frame.add(addressLb);
        frame.add(addressTf);
        frame.add(refLb);
        frame.add(refTf);
        frame.add(save);
        frame.add(back);

        back.addActionListener(e->{
            frame.dispose();
            new CustomerPanelUI();
        });

        save.addActionListener(e->{

            try {
                customerService.save(nameTf.getText(), numberTf.getText(),
                        cnicTf.getText(), addressTf.getText(), refTf.getText());
                frame.dispose();
                new CustomerPanelUI();

            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame,"Unable to save");
            }

        });

        frame.setSize(1400,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
