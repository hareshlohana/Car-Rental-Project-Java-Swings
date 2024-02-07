package org.car_rantel.UI;

import org.car_rantel.service.CustomerService;
import org.car_rantel.service.VehicleOwnerService;

import javax.swing.*;
import java.awt.*;

public class AddVehicleOwnerUI {
    private final VehicleOwnerService vehicleOwnerService = new VehicleOwnerService();
    public AddVehicleOwnerUI(){
        JFrame frame = new JFrame("ADD VEHICLE OWNER ");
        frame.setLayout(new GridLayout(6,4,10,10));

        JLabel nameLb = new JLabel("NAME");
        JTextField nameTf = new JTextField(20);

        JLabel numberLb = new JLabel("NUMBER");
        JTextField numberTf = new JTextField(20);

        JLabel cnicLb = new JLabel("CNIC");
        JTextField cnicTf = new JTextField(20);

        JLabel addressLb = new JLabel("ADDRESS");
        JTextField addressTf = new JTextField(20);

        JLabel commissionLb = new JLabel("COMMISSION");
        JTextField commissionTf = new JTextField(20);

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
        frame.add(commissionLb);
        frame.add(commissionTf);
        frame.add(save);
        frame.add(back);

        back.addActionListener(e->{
            frame.dispose();
            new VehicleOwnerPanelUI();
        });

        save.addActionListener(e->{

            try {
                vehicleOwnerService.save(nameTf.getText(), numberTf.getText(),
                        cnicTf.getText(), addressTf.getText(), commissionTf.getText());
                frame.dispose();
                new VehicleOwnerPanelUI();

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
