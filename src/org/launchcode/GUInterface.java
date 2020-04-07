package org.launchcode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUInterface {

    public static void createAndShowGui() {
        JFrame mainFrame = new JFrame("First assignment");


        JPanel myPanel = new JPanel();

//=============labels and text fields==================
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(10,20,80,25);
        myPanel.add(nameLabel);
        JTextField nameField = new JTextField(10);
        nameField.setBounds(150,20,165,20);
        myPanel.add(nameField);

       JLabel surnameLabel = new JLabel("Surname: ");
       surnameLabel.setBounds(10,50,80,25);
       myPanel.add(surnameLabel);
       JTextField surnameField = new JTextField(20);
       surnameField.setBounds(150,50,165,20);
       myPanel.add(surnameField);

       JLabel majorLabel = new JLabel("Major: ");
       majorLabel.setBounds(10,80,80,25);
       myPanel.add(majorLabel);
       JComboBox majorCombo = new JComboBox();
       majorCombo.addItem("Informatyka");
       majorCombo.addItem("Architektura wnetrz");
       majorCombo.addItem("Grafika");
       majorCombo.addItem("Kulturoznawstwo");
       majorCombo.addItem("Zarzadzanie informacja");
       majorCombo.setBounds(150,80,165,20);
       myPanel.add(majorCombo);

        JLabel yearLabel = new JLabel("Year of Study: ");
        yearLabel.setBounds(10,110,120,25);
        myPanel.add(yearLabel);
        JComboBox yearCombo = new JComboBox();
        yearCombo.addItem(1);
        yearCombo.addItem(2);
        yearCombo.addItem(3);
        yearCombo.addItem(4);
        yearCombo.addItem(5);
        yearCombo.setBounds(150,110,165,20);
        myPanel.add(yearCombo);

        //============END OF LABELS AND TEXT FIELDS==============

//        JLabel averageGradeLabel = new JLabel("Average Grade: ");
//        averageGradeLabel.setBounds(10,140,120,25);
//        myPanel.add(averageGradeLabel);
//        JTextField averageGradeField = new JTextField(10);
//        averageGradeField.setBounds(150,140,165,20);
//        averageGradeField.setEditable(false);
//        myPanel.add(averageGradeField);




        myPanel.setLayout(null);
        mainFrame.setSize(800,500);                    // setting window size
        mainFrame.setContentPane(myPanel);                          // adding a panel onto mainFrame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // window closing when click on Exit button
        mainFrame.setVisible(true);


    }

}

