package org.launchcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;

public class GUInterface extends JFrame{


    public static void createAndShowGui() {
        JFrame mainFrame = new JFrame("First assignment");
        JPanel myPanel = new JPanel(null);
        JTextArea studentTextArea = new JTextArea();

        Home menu = new Home();
        menu.homePanel(myPanel);
        menu.addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("add")) {
                    menu.success1.setVisible(true);

                    StudentsMajor selectedMajor = (StudentsMajor) menu.majorCombo.getSelectedItem();
                    int selectedYear = (int) menu.yearCombo.getSelectedItem();

                    Student studentData = new Student(menu.nameField.getText(), menu.surnameField.getText(), selectedMajor, selectedYear, 0.0);
                    menu.studentList.add(studentData.toString());
                }
            }
        });


        menu.showStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                studentTextArea.setVisible(true);
                studentTextArea.setBounds(10,250,980,320);
                studentTextArea.setEditable(false);
                studentTextArea.setBackground(Color.lightGray);
                myPanel.add(studentTextArea);
                myPanel.repaint();

                for (String stud : menu.studentList){
                    studentTextArea.append(stud + "\n");
                }


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

