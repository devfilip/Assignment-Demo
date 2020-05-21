package org.launchcode;

import javax.swing.*;
import java.awt.*;

public class GUInterface{


    public static void createAndShowGui() {
        JFrame mainFrame = new JFrame("First assignment");
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel menu = new JPanel(new FlowLayout());
        JPanel addForm = new JPanel(new GridLayout(0,2,20,10));
        
        JButton addStudent = new JButton("Add student");
        JButton showStudents = new JButton("Display students list");
        JButton modifyStudent = new JButton("Edit student");
        JButton deleteStudent = new JButton("Delete student");
        JButton searchStudent = new JButton("Search");

        JLabel nameLabel = new JLabel("Name: ");
        JLabel surnameLabel = new JLabel("Surname: ");
        JLabel majorLabel = new JLabel("Major: ");
        JLabel yearLabel = new JLabel("Year of Study: ");
        JLabel avgLabel = new JLabel("Avg. grade: ");
        JLabel empty = new JLabel("");

        JTextField nameField = new JTextField(15);
        JTextField surnameField = new JTextField(15);
        JComboBox majorCombo = new JComboBox(StudentsMajor.values());
        JTextField yearField = new JTextField(15);
        JTextField avgField = new JTextField(15);

        JButton apply = new JButton("Submit");

        Font butFont = new Font("Helvetica",Font.CENTER_BASELINE, 13);

        menu.setBackground(Color.darkGray);
        addStudent.setFont(butFont);
        showStudents.setFont(butFont);
        modifyStudent.setFont(butFont);
        deleteStudent.setFont(butFont);
        searchStudent.setFont(butFont);

        addForm.setBackground(Color.darkGray);
        addForm.setForeground(Color.WHITE);

        menu.add(addStudent);
        menu.add(showStudents);
        menu.add(modifyStudent);
        menu.add(deleteStudent);
        menu.add(searchStudent);
        menu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        mainPanel.add(menu, BorderLayout.NORTH);
        addStudent.addActionListener(e -> {
            addForm.add(nameLabel);
            addForm.add(nameField);
            addForm.add(surnameLabel);
            addForm.add(surnameField);
            addForm.add(majorLabel);
            addForm.add(majorCombo);
            addForm.add(yearLabel);
            addForm.add(yearField);
            addForm.add(avgLabel);
            addForm.add(avgField);
            addForm.add(empty);
            addForm.add(apply);

            mainPanel.add(addForm,BorderLayout.CENTER);
            mainPanel.revalidate();
        });

        apply.addActionListener(e -> {
            Student student = new Student(nameField.getText(),
                    surnameField.getText(),
                    (StudentsMajor)majorCombo.getSelectedItem(),
                    Integer.parseInt(yearField.getText()),
                    Double.parseDouble(avgField.getText()));
        });

        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();      // setting window size
        mainFrame.setSize(screenDim.width / 2,screenDim.height / 2);
        mainFrame.setLocation(screenDim.width / 4, screenDim.height / 4);
        mainFrame.setContentPane(mainPanel);          // adding a panel onto mainFrame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // window closing when click on Exit button
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.darkGray);
        mainPanel.setBackground(Color.darkGray);


    }


}

