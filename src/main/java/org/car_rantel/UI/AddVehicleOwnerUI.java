package org.car_rantel.UI;

import org.car_rantel.dao.CustomerDAO;
import org.car_rantel.dao.Vehicle_OwnerDAO;
import org.car_rantel.domain.Customer;
import org.car_rantel.domain.Vehicle_Owner;
import org.car_rantel.service.VehicleOwnerService;

import javax.swing.*;
import java.awt.*;

public class AddVehicleOwnerUI {
    private final VehicleOwnerService vehicleOwnerService = new VehicleOwnerService();
    public AddVehicleOwnerUI(Integer index){
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

        if (index != null && index > -1){
            Vehicle_Owner vehicle_owner = Vehicle_OwnerDAO.getByIndex(index);
            nameTf.setText(vehicle_owner.getOwner_name());
            numberTf.setText(vehicle_owner.getOwner_number());
            cnicTf.setText(vehicle_owner.getCnic());
            addressTf.setText(vehicle_owner.getAddress());
            commissionTf.setText(String.valueOf(vehicle_owner.getCommission()));
        }

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
                if (nameTf.getText().isEmpty() || numberTf.getText().isEmpty() ||
                        cnicTf.getText().isEmpty() || addressTf.getText().isEmpty() || commissionTf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Please fill Data!!");
                    return;
                }

                if (index != null){
                    vehicleOwnerService.updateVehicleOwner(index, nameTf.getText(), numberTf.getText(),
                            cnicTf.getText(), addressTf.getText(), commissionTf.getText());
                    frame.dispose();
                    new VehicleOwnerPanelUI();
                }else {
                    vehicleOwnerService.save(nameTf.getText(), numberTf.getText(),
                            cnicTf.getText(), addressTf.getText(), commissionTf.getText());
                    frame.dispose();
                    new VehicleOwnerPanelUI();
                }
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
