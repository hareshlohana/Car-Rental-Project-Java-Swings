package org.car_rantel.UI;

import org.car_rantel.service.CustomerService;
import org.car_rantel.service.VehicleService;

import javax.swing.*;
import java.awt.*;

public class AddVehicleUI {
    private final VehicleService vehicleService = new VehicleService();
    public AddVehicleUI(){
        JFrame frame = new JFrame("ADD VEHICLE ");
        frame.setLayout(new GridLayout(6,4,10,10));

        JLabel nameLb = new JLabel("NAME");
        JTextField nameTf = new JTextField(20);

        JLabel modelLb = new JLabel("MODEL");
        JTextField modelTf = new JTextField(20);

        JLabel brandLb = new JLabel("BRAND");
        JTextField brandTf = new JTextField(20);

        JLabel colorLb = new JLabel("COLOR");
        JTextField colorTf = new JTextField(20);

        JLabel ownerIdLb = new JLabel("OWNER_ID");
        JTextField ownerIdTf = new JTextField(20);

        JButton back = new JButton("BACK");
        JButton save = new JButton("SAVE");

        frame.add(nameLb);
        frame.add(nameTf);
        frame.add(modelLb);
        frame.add(modelTf);
        frame.add(brandLb);
        frame.add(brandTf);
        frame.add(colorLb);
        frame.add(colorTf);
        frame.add(ownerIdLb);
        frame.add(ownerIdTf);
        frame.add(save);
        frame.add(back);

        back.addActionListener(e->{
            frame.dispose();
            new VehiclePanelUI();
        });

        save.addActionListener(e->{

            try {
                vehicleService.save(nameTf.getText(), modelTf.getText(),
                        brandTf.getText(), colorTf.getText(), ownerIdTf.getText());
                frame.dispose();
                new VehiclePanelUI();

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
