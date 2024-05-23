package org.car_rantel.UI;

import org.car_rantel.service.AuthenticationService;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class LoginUI {

    private final AuthenticationService authenticationService = new AuthenticationService();
    public LoginUI(){
        JFrame frame = new JFrame("Car Rental APP");

//        JFrame Fields
        JTextField usertf= new JFormattedTextField("Username");
        usertf.setBounds(150, 100, 200, 30);

        JTextField passtf = new JFormattedTextField("Password");
        passtf.setBounds(150, 150, 200, 30);

        JButton loginbtn = new JButton("Login");
        loginbtn.setBounds(200, 200, 100, 30);


//        Add Fields on Frame Sequence wise
        frame.add(usertf);
        frame.add(passtf);
        frame.add(loginbtn);

        //        Check Login
        loginbtn.addActionListener((event)->{
            if (authenticationService.checkLogin(usertf.getText(), passtf.getText())){
                    frame.dispose();
                new HomeUI();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Username and Password");
            }
        });

//        Set Field Basic Properties
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
