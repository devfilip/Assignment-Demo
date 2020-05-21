package org.launchcode;

import javax.swing.*;
import java.awt.*;

public class GUInterface{


    public static void createAndShowGui() {
        JFrame mainFrame = new JFrame("First assignment");
//        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel menu = new JPanel(new FlowLayout());
        FormPanel addForm = new FormPanel();
        StudentList table = new StudentList();
        
        JButton addStudent = new JButton("Add student");
        JButton showStudents = new JButton("Display students list");
        JButton modifyStudent = new JButton("Edit student");
        JButton deleteStudent = new JButton("Delete student");
        JButton searchStudent = new JButton("Search");

        Font butFont = new Font("Helvetica",Font.CENTER_BASELINE, 13);

        menu.setBackground(Color.darkGray);
        addStudent.setFont(butFont);
        showStudents.setFont(butFont);
        modifyStudent.setFont(butFont);
        deleteStudent.setFont(butFont);
        searchStudent.setFont(butFont);


        menu.add(addStudent);
        menu.add(showStudents);
        menu.add(modifyStudent);
        menu.add(deleteStudent);
        menu.add(searchStudent);
        menu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        mainFrame.add(menu, BorderLayout.NORTH);
        addStudent.addActionListener(e -> {
            mainFrame.add(addForm.getAddForm(),BorderLayout.CENTER);
            mainFrame.revalidate();
        });

        showStudents.addActionListener(e -> {
            mainFrame.add(table.getPanel(), BorderLayout.SOUTH);
            mainFrame.revalidate();
        });


        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();      // setting window size
        mainFrame.setSize(screenDim.width / 2,screenDim.height / 2);
        mainFrame.setLocation(screenDim.width / 4, screenDim.height / 4);
//        mainFrame.setContentPane(mainPanel);          // adding a panel onto mainFrame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // window closing when click on Exit button
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.darkGray);
//        mainPanel.setBackground(Color.darkGray);


    }


}

