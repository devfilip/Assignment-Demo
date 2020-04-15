package org.launchcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;

public class GUInterface {


    public static void createAndShowGui() {
        AddingInterface addMenu = new AddingInterface();
        JFrame mainFrame = new JFrame("First assignment");
        JPanel myPanel = new JPanel(null);

        Home menu = new Home();
        menu.homePanel(myPanel);
        menu.addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMenu.createAddingInterface(myPanel);
                myPanel.revalidate();
            }
        });

        menu.showStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel listLabel = new JLabel();
                listLabel.setBounds(30,350,800,400);
                addMenu.showList();
            }
        });

        menu.modifyStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        mainFrame.setSize(1000,600);                    // setting window size
        mainFrame.setContentPane(myPanel);          // adding a panel onto mainFrame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // window closing when click on Exit button
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.darkGray);
        myPanel.setBackground(Color.darkGray);


    }


}

