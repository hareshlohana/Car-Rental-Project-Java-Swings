package org.car_rantel.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.sun.glass.ui.Cursor.setVisible;

public class WelcomePageUI {
    public WelcomePageUI() {
        JFrame frame = new JFrame("Car Rental Welcome Page");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton welcomebtn = new JButton("Welcome To Car Rental Application ");
        addWelcomeImageOnButton(welcomebtn, "D:\\Idea Projects\\car_rental_db\\src\\main\\resources\\Welcome.jpg", 800,620);
        welcomebtn.addActionListener(e->{
            frame.dispose();
            new HomeUI();
        });

        btnPanel.add(welcomebtn);
        frame.add(btnPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void addWelcomeImageOnButton(JButton welcomebtn, String imagepath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagepath);
        Image newImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        welcomebtn.setIcon(new ImageIcon(newImage));
    }
}
