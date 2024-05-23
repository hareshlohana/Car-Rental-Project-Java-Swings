package org.car_rantel.UI;

import javax.swing.*;
import java.awt.*;

public class HomeUI {
    public HomeUI(){
        JFrame frame = new JFrame("Car Rental Home Page");

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,50));

        JButton customerbtn = new JButton("Customer ");
        addCustomerImageOnButton(customerbtn,"D:\\Idea Projects\\car_rental_db\\src\\main\\resources\\customer.png",100,120 );

        customerbtn.addActionListener(e-> {
            frame.dispose();
            new CustomerPanelUI();
        });

        JButton vehiclebtn = new JButton("Vehicle ");
        addVehicleImageOnButton(vehiclebtn, "D:\\Idea Projects\\car_rental_db\\src\\main\\resources\\Vehicle.jpg", 100,120);

        vehiclebtn.addActionListener(e->{
            frame.dispose();
            new VehiclePanelUI();
        });

        JButton vehicleOwnerbtn = new JButton("Vehicle Owner ");
        addVehicleOwnerImageOnButton(vehicleOwnerbtn, "D:\\Idea Projects\\car_rental_db\\src\\main\\resources\\Vehicle Owner.png", 100,120);

        vehicleOwnerbtn.addActionListener(e->{
            frame.dispose();
            new VehicleOwnerPanelUI();
        });

        JButton bookingbtn = new JButton("Booking ");
        addBookingImageOnButton(bookingbtn, "D:\\Idea Projects\\car_rental_db\\src\\main\\resources\\booking.jpg", 100,120);

        bookingbtn.addActionListener(e->{
            frame.dispose();
            new BookingPanelUI();
        });

        JButton userbtn = new JButton("User ");
        addUserImageOnButton(userbtn, "D:\\Idea Projects\\car_rental_db\\src\\main\\resources\\User.png", 100,120);
        userbtn.addActionListener(e->{
            frame.dispose();
            new LoginUI();
        });


        JButton logoutbtn = new JButton("Logout ");
        addLogoutImageOnButton(logoutbtn, "D:\\Idea Projects\\car_rental_db\\src\\main\\resources\\logout.png", 100,120);
        logoutbtn.addActionListener(e->{
            frame.dispose();
        });

        btnPanel.add(customerbtn); btnPanel.add(vehiclebtn); btnPanel.add(vehicleOwnerbtn);
        btnPanel.add(bookingbtn); btnPanel.add(userbtn); btnPanel.add(logoutbtn);

        frame.add(btnPanel);


//        Set Field Basic Properties
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void addCustomerImageOnButton(JButton button, String imagepath,int height, int width) {
        ImageIcon imageIcon = new ImageIcon(imagepath);
        Image newImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(newImage));
    }

    public static void addVehicleImageOnButton(JButton button, String imagepath,int height, int width) {
        ImageIcon imageIcon = new ImageIcon(imagepath);
        Image newImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(newImage));
    }

    public static void addVehicleOwnerImageOnButton(JButton button, String imagepath,int height, int width) {
        ImageIcon imageIcon = new ImageIcon(imagepath);
        Image newImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(newImage));
    }

    public static void addBookingImageOnButton(JButton button, String imagepath,int height, int width) {
        ImageIcon imageIcon = new ImageIcon(imagepath);
        Image newImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(newImage));
    }

    public static void addUserImageOnButton(JButton button, String imagepath,int height, int width) {
        ImageIcon imageIcon = new ImageIcon(imagepath);
        Image newImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(newImage));
    }

    public static void addLogoutImageOnButton(JButton button, String imagepath,int height, int width) {
        ImageIcon imageIcon = new ImageIcon(imagepath);
        Image newImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(newImage));
    }
}
