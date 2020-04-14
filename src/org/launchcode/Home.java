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
        showStudents.setBounds(30,60,200,25);
        modifyStudent.setBounds(30,90,200,25);
        deleteStudent.setBounds(30,120,200,25);
        searchStudent.setBounds(30,150,200,25);

        panel.add(addStudent);
        panel.add(showStudents);
        panel.add(modifyStudent);
        panel.add(deleteStudent);
        panel.add(searchStudent);

    }

}
