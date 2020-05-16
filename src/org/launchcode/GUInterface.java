package org.launchcode;

import javax.swing.*;
import javax.swing.SpringLayout;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;

public class GUInterface{


    public static void createAndShowGui() {
        JFrame mainFrame = new JFrame("First assignment");
        JPanel mainPanel = new JPanel(new BorderLayout());
        JTextArea studentTextArea = new JTextArea();
        JLabel successDel = new JLabel("Student deleted successfully!");
        JLabel success1 = new JLabel("Student added successfully!");
        ArrayList<Student> studentList;


        JButton addStudent = new JButton("Add student");
        JButton showStudents = new JButton("Display students list");
        JButton modifyStudent = new JButton("Edit student");
        JButton deleteStudent = new JButton("Delete all");
        JButton searchStudent = new JButton("Search");

        JPanel butPanel = new JPanel();
        butPanel.setLayout(new BoxLayout(butPanel,BoxLayout.PAGE_AXIS));
        butPanel.setBackground(Color.darkGray);
        mainPanel.add(butPanel, BorderLayout.LINE_START);
        Font butFont = new Font("Helvetica",Font.CENTER_BASELINE, 13);

        addStudent.setFont(butFont);
        showStudents.setFont(butFont);
        modifyStudent.setFont(butFont);
        deleteStudent.setFont(butFont);
        searchStudent.setFont(butFont);

        butPanel.add(addStudent);
        butPanel.add(Box.createRigidArea(new Dimension(5,5)));
        butPanel.add(showStudents);
        butPanel.add(Box.createRigidArea(new Dimension(5,5)));
        butPanel.add(modifyStudent);
        butPanel.add(Box.createRigidArea (new Dimension(5,5)));
        butPanel.add(deleteStudent);
        butPanel.add(Box.createRigidArea(new Dimension(5,5)));
        butPanel.add(searchStudent);
        butPanel.add(Box.createRigidArea(new Dimension(5,5)));

        JPanel formPanel = new JPanel(new SpringLayout());
        formPanel.setBackground(Color.darkGray);

        studentList = new ArrayList<Student>();
        String[] labels = {"Name: ", "Surname: ", "Major: ", "Year of Study: ", "Average grade: "};

        int numPairs = labels.length;

        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            l.setForeground(Color.white);
            formPanel.add(l);
            JTextField textField = new JTextField(20);
            l.setLabelFor(textField);
            formPanel.add(textField);
        }
        layout.SpringUtilities.makeCompactGrid(formPanel,
                numPairs, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        mainPanel.add(formPanel, BorderLayout.CENTER);

        mainPanel.add(success1, BorderLayout.LINE_END);
        success1.setVisible(false);
        success1.setFont(new Font("Helvetica", Font.ITALIC, 14));
        success1.setForeground(Color.yellow);

//       addStudent.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getActionCommand().equals("add")) {
//                    success1.setVisible(true);
//
//                    StudentsMajor selectedMajor = (StudentsMajor)majorCombo.getSelectedItem();
//                    int selectedYear = (int) yearCombo.getSelectedItem();
//                    double avg = Double.valueOf(averageField.getText());
//
//
//                    Student studentData = new Student(nameField.getText(), surnameField.getText(), selectedMajor, selectedYear,avg);
//                    studentList.add(studentData);
//                    studentTextArea.setText("");
//                    studentTextArea.setVisible(false);
//                }
//            }
//        });


//        menu.showStudents.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                menu.success1.setVisible(false);
//                successDel.setVisible(false);
//                studentTextArea.setVisible(true);
//                studentTextArea.setBounds(10,250,980,320);
//                studentTextArea.setEditable(false);
//                studentTextArea.setBackground(Color.lightGray);
//                mainPanel.add(studentTextArea);
//                mainPanel.repaint();
//
//                    for (Student stud : menu.studentList) {
//                            studentTextArea.append(stud + "\n");
//                    }
//
//
//            }
//        });
//
//        menu.modifyStudent.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        menu.deleteStudent.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                menu.studentList.removeAll(menu.studentList);
//                studentTextArea.setText("");
//                studentTextArea.setVisible(false);
//                successDel.setVisible(true);
//                successDel.setBounds(730, 80, 200, 20);
//                successDel.setFont(new Font("Helvetica", Font.ITALIC, 14));
//                successDel.setForeground(Color.yellow);
//                mainPanel.add(successDel);
//                mainPanel.repaint();
//            }
//        });


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

