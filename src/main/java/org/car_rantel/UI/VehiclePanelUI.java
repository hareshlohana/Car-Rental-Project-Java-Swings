package org.car_rantel.UI;

import org.car_rantel.dao.CustomerDAO;
import org.car_rantel.dao.VehicleDAO;
import org.car_rantel.service.CustomerService;
import org.car_rantel.service.VehicleService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VehiclePanelUI {
    private final VehicleService vehicleService = new VehicleService();
    public VehiclePanelUI(){
        JFrame jFrame = new JFrame("Vehicle Panel");

        JPanel tblAndSearchPanel = new JPanel();
        tblAndSearchPanel.setBackground(Color.GRAY);
        tblAndSearchPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JTextField searchTF = new JTextField(30);

        String[][] data = vehicleService.getAllVehicleForJTable();

        String column[]={"NAME","MODEL","BRAND","COLOR","OWNER_ID"};

        DefaultTableModel dtm = new DefaultTableModel(data,column);
        JTable jt=new JTable(dtm);
//        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);

        tblAndSearchPanel.add(searchTF);
        tblAndSearchPanel.add(sp);

        JPanel actionButtonPanel = new JPanel();
        actionButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JButton addVehicleButton = new JButton("ADD");
        JButton editVehicleButton = new JButton("EDIT");
        JButton deleteVehicleButton = new JButton("DELETE");
        JButton back = new JButton("BACK");

        actionButtonPanel.add(addVehicleButton);
        actionButtonPanel.add(editVehicleButton);
        actionButtonPanel.add(deleteVehicleButton);
        actionButtonPanel.add(back);

        addVehicleButton.addActionListener(e->{
            jFrame.dispose();
            new AddVehicleUI(jt.getSelectedRow());
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
                String[][] data = vehicleService.searchByName(searchTF.getText());
                DefaultTableModel dtm = new DefaultTableModel(data,column);
                jt.setModel(dtm);
            }
        });

        deleteVehicleButton.addActionListener(e ->{
            if (jt.getSelectedRow() > -1){
                VehicleDAO.deleteByIndex(jt.getSelectedRow());
                dtm.removeRow(jt.getSelectedRow());
            }
        });

        editVehicleButton.addActionListener(e->{
            if (jt.getSelectedRow() > -1){
                jFrame.dispose();
                VehicleDAO.getByIndex(jt.getSelectedRow());
                new AddVehicleUI(jt.getSelectedRow());
            }else{
                JOptionPane.showMessageDialog(jFrame, "Please Select the Row!");
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
