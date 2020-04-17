package org.launchcode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home {
    JButton addStudent = new JButton("Add student");
    JButton showStudents = new JButton("Display students list");
    JButton modifyStudent = new JButton("Edit student");
    JButton deleteStudent = new JButton("Delete all");
    JButton searchStudent = new JButton("Search");

    JLabel nameLabel = new JLabel("Name: ");
    JTextField nameField = new JTextField(10);

    JLabel surnameLabel = new JLabel("Surname: ");
    JTextField surnameField = new JTextField(20);

    JLabel majorLabel = new JLabel("Major: ");
    JComboBox majorCombo = new JComboBox();

    JLabel yearLabel = new JLabel("Year of Study: ");
    JComboBox yearCombo = new JComboBox();

    JLabel averageLabel = new JLabel("Average grade: ");
    JTextField averageField = new JTextField("0.0",20);
    JLabel success1 = new JLabel("Student added successfully!");
    ArrayList<Student> studentList;
    public void homePanel(JPanel panel){
        addStudent.setBounds(30,30,200,25);
        addStudent.setFont(new Font("Helvetica",Font.CENTER_BASELINE, 13));
        addStudent.setActionCommand("add");

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

        studentList = new ArrayList<Student>();


        nameLabel.setBounds(400, 30, 80, 25);
        nameLabel.setFont(new Font("Courier New", Font.BOLD, 12));
        nameLabel.setForeground(Color.white);
        panel.add(nameLabel);

        nameField.setBounds(520, 35, 165, 20);
        panel.add(nameField);


        surnameLabel.setBounds(400, 60, 80, 25);
        surnameLabel.setFont(new Font("Courier New", Font.BOLD, 12));
        surnameLabel.setForeground(Color.white);
        panel.add(surnameLabel);

        surnameField.setBounds(520, 65, 165, 20);
        panel.add(surnameField);


        majorLabel.setBounds(400, 90, 80, 25);
        majorLabel.setFont(new Font("Courier New", Font.BOLD, 12));
        majorLabel.setForeground(Color.white);
        panel.add(majorLabel);

        majorCombo.setModel(new DefaultComboBoxModel(StudentsMajor.values()));
        majorCombo.setBounds(520, 95, 165, 20);
        panel.add(majorCombo);


        yearLabel.setBounds(400, 120, 120, 25);
        yearLabel.setFont(new Font("Courier New", Font.BOLD, 12));
        yearLabel.setForeground(Color.white);
        panel.add(yearLabel);


        yearCombo.addItem(1);
        yearCombo.addItem(2);
        yearCombo.addItem(3);
        yearCombo.addItem(4);
        yearCombo.addItem(5);
        yearCombo.setBounds(520, 125, 165, 20);
        panel.add(yearCombo);


        averageLabel.setBounds(400, 150, 120, 25);
        averageLabel.setFont(new Font("Courier New", Font.BOLD, 12));
        averageLabel.setForeground(Color.white);
        panel.add(averageLabel);


        averageField.setBounds(520, 155, 165, 20);
        averageField.setEditable(false);
        averageField.setBackground(Color.lightGray);
        panel.add(averageField);


        panel.repaint();


        success1.setVisible(false);
        success1.setBounds(730, 80, 200, 20);
        success1.setFont(new Font("Helvetica", Font.ITALIC, 14));
        success1.setForeground(Color.yellow);
        panel.add(success1);

    }

}
