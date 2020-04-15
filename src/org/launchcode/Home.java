package org.launchcode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Home {
    JButton addStudent = new JButton("Add student");
    JButton showStudents = new JButton("Display students list");
    JButton modifyStudent = new JButton("Edit student");
    JButton deleteStudent = new JButton("Delete student");
    JButton searchStudent = new JButton("Search");

    public void homePanel(JPanel panel){
        addStudent.setBounds(30,30,200,25);
        addStudent.setFont(new Font("Helvetica",Font.CENTER_BASELINE, 13));

        showStudents.setBounds(30,60,200,25);
        showStudents.setFont(new Font("Helvetica",Font.CENTER_BASELINE, 13));
        showStudents.setActionCommand("show");

        modifyStudent.setBounds(30,90,200,25);
        modifyStudent.setFont(new Font("Helvetica",Font.CENTER_BASELINE, 13));

        deleteStudent.setBounds(30,120,200,25);
        deleteStudent.setFont(new Font("Helvetica",Font.CENTER_BASELINE, 13));

        searchStudent.setBounds(30,150,200,25);
        searchStudent.setFont(new Font("Helvetica",Font.CENTER_BASELINE, 13));

        panel.add(addStudent);
        panel.add(showStudents);
        panel.add(modifyStudent);
        panel.add(deleteStudent);
        panel.add(searchStudent);

    }

}
