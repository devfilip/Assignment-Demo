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
        JLabel successDel = new JLabel("Student deleted successfully!");

        Home menu = new Home();
        menu.homePanel(myPanel);
        menu.addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("add")) {
                    menu.success1.setVisible(true);

                    StudentsMajor selectedMajor = (StudentsMajor) menu.majorCombo.getSelectedItem();
                    int selectedYear = (int) menu.yearCombo.getSelectedItem();
                    double avg = Double.valueOf(menu.averageField.getText());


                    Student studentData = new Student(menu.nameField.getText(), menu.surnameField.getText(), selectedMajor, selectedYear,avg);
                    menu.studentList.add(studentData);
                    studentTextArea.setText("");
                    studentTextArea.setVisible(false);
                }
            }
        });


        menu.showStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                menu.success1.setVisible(false);
                successDel.setVisible(false);
                studentTextArea.setVisible(true);
                studentTextArea.setBounds(10,250,980,320);
                studentTextArea.setEditable(false);
                studentTextArea.setBackground(Color.lightGray);
                myPanel.add(studentTextArea);
                myPanel.repaint();

                    for (Student stud : menu.studentList) {
                            studentTextArea.append(stud + "\n");
                    }


            }
        });

        menu.modifyStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        menu.deleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.studentList.removeAll(menu.studentList);
                studentTextArea.setText("");
                studentTextArea.setVisible(false);
                successDel.setVisible(true);
                successDel.setBounds(730, 80, 200, 20);
                successDel.setFont(new Font("Helvetica", Font.ITALIC, 14));
                successDel.setForeground(Color.yellow);
                myPanel.add(successDel);
                myPanel.repaint();
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

