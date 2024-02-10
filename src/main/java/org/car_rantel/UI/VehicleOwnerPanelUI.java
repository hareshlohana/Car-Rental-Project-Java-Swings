package org.car_rantel.UI;

import org.car_rantel.dao.Vehicle_OwnerDAO;
import org.car_rantel.service.VehicleOwnerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VehicleOwnerPanelUI {
    private final VehicleOwnerService vehicleOwnerService = new VehicleOwnerService();
    public VehicleOwnerPanelUI(){
        JFrame jFrame = new JFrame("Vehicle Panel");

        JPanel tblAndSearchPanel = new JPanel();
        tblAndSearchPanel.setBackground(Color.GRAY);
        tblAndSearchPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JTextField searchTF = new JTextField(30);

        String[][] data = vehicleOwnerService.getAllVehicleOwnerForJTable();

        String column[]={"NAME","NUMBER","CNIC","ADDRESS","COMMISSION"};

        DefaultTableModel dtm = new DefaultTableModel(data,column);
        JTable jt=new JTable(dtm);
//        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);

        tblAndSearchPanel.add(searchTF);
        tblAndSearchPanel.add(sp);

        JPanel actionButtonPanel = new JPanel();
        actionButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JButton addVehicleOwnerButton = new JButton("ADD");
        JButton editVehicleOwnerButton = new JButton("EDIT");
        JButton deleteVehicleOwnerButton = new JButton("DELETE");
        JButton back = new JButton("BACK");

        actionButtonPanel.add(addVehicleOwnerButton);
        actionButtonPanel.add(editVehicleOwnerButton);
        actionButtonPanel.add(deleteVehicleOwnerButton);
        actionButtonPanel.add(back);

        addVehicleOwnerButton.addActionListener(e->{
            jFrame.dispose();
            new AddVehicleOwnerUI(jt.getSelectedRow());
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
                String[][] data = vehicleOwnerService.searchByName(searchTF.getText());
                DefaultTableModel dtm = new DefaultTableModel(data,column);
                jt.setModel(dtm);
            }
        });

        deleteVehicleOwnerButton.addActionListener(e ->{
            if (jt.getSelectedRow() > -1){
                Vehicle_OwnerDAO.deleteByIndex(jt.getSelectedRow());
                dtm.removeRow(jt.getSelectedRow());
            }
        });

        editVehicleOwnerButton.addActionListener(e->{
            if (jt.getSelectedRow() > -1){
                jFrame.dispose();
                Vehicle_OwnerDAO.getByIndex(jt.getSelectedRow());
                new AddVehicleOwnerUI(jt.getSelectedRow());
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
