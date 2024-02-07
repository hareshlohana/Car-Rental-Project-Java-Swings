package org.car_rantel.UI;

import org.car_rantel.dao.CustomerDAO;
import org.car_rantel.service.CustomerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomerPanelUI {

    private final CustomerService customerService = new CustomerService();
    public CustomerPanelUI(){
        JFrame jFrame = new JFrame("Customer Panel");

        JPanel tblAndSearchPanel = new JPanel();
        tblAndSearchPanel.setBackground(Color.GRAY);
        tblAndSearchPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JTextField searchTF = new JTextField(30);

        String[][] data = customerService.getAllCustomerForJTable();

        String column[]={"NAME","NUMBER","CNIC","ADDRESS","REF_NUMBER"};

        DefaultTableModel dtm = new DefaultTableModel(data,column);
        JTable jt=new JTable(dtm);
//        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);

        tblAndSearchPanel.add(searchTF);
        tblAndSearchPanel.add(sp);

        JPanel actionButtonPanel = new JPanel();
        actionButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JButton addCustomerButton = new JButton("ADD");
        JButton editCustomerButton = new JButton("EDIT");
        JButton deleteCustomerButton = new JButton("DELETE");
        JButton back = new JButton("BACK");

        actionButtonPanel.add(addCustomerButton);
        actionButtonPanel.add(editCustomerButton);
        actionButtonPanel.add(deleteCustomerButton);
        actionButtonPanel.add(back);

        addCustomerButton.addActionListener(e->{
            jFrame.dispose();
            new AddCustomerUI(jt.getSelectedRow());
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
                String[][] data =  customerService.searchByName(searchTF.getText());
                DefaultTableModel dtm = new DefaultTableModel(data,column);
                jt.setModel(dtm);
            }
        });

          deleteCustomerButton.addActionListener(e ->{
              if (jt.getSelectedRow() > -1){
                  CustomerDAO.deleteByIndex(jt.getSelectedRow());
                  dtm.removeRow(jt.getSelectedRow());
              }else{
                  JOptionPane.showMessageDialog(jFrame, "Please Select the Row!");
              }
          });

          editCustomerButton.addActionListener(e->{
              if (jt.getSelectedRow() > -1){
                  jFrame.dispose();
                  new AddCustomerUI(jt.getSelectedRow());
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
