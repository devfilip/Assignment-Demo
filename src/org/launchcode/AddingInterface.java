package org.launchcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddingInterface{

    private ArrayList<String> studentList;
    public void createAddingInterface(JPanel panel){
        studentList = new ArrayList<String>();
        //=============labels and text fields==================
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(400,50,80,25);
        nameLabel.setFont(new Font("Courier New",Font.BOLD,12));
        nameLabel.setForeground(Color.white);
        panel.add(nameLabel);
        JTextField nameField = new JTextField(10);
        nameField.setBounds(520,55,165,20);
        panel.add(nameField);

        JLabel surnameLabel = new JLabel("Surname: ");
        surnameLabel.setBounds(400,80,80,25);
        surnameLabel.setFont(new Font("Courier New",Font.BOLD,12));
        surnameLabel.setForeground(Color.white);
        panel.add(surnameLabel);
        JTextField surnameField = new JTextField(20);
        surnameField.setBounds(520,85,165,20);
        panel.add(surnameField);

        JLabel majorLabel = new JLabel("Major: ");
        majorLabel.setBounds(400,110,80,25);
        majorLabel.setFont(new Font("Courier New",Font.BOLD,12));
        majorLabel.setForeground(Color.white);
        panel.add(majorLabel);
        JComboBox majorCombo = new JComboBox();
        majorCombo.addItem(StudentsMajor.IT);
        majorCombo.addItem(StudentsMajor.AW);
        majorCombo.addItem(StudentsMajor.GRAPH);
        majorCombo.addItem(StudentsMajor.CULT);
        majorCombo.addItem(StudentsMajor.IM);
        majorCombo.setBounds(520,115,165,20);
        panel.add(majorCombo);


        JLabel yearLabel = new JLabel("Year of Study: ");
        yearLabel.setBounds(400,140,120,25);
        yearLabel.setFont(new Font("Courier New",Font.BOLD,12));
        yearLabel.setForeground(Color.white);
        panel.add(yearLabel);
        JComboBox yearCombo = new JComboBox();
        yearCombo.addItem(1);
        yearCombo.addItem(2);
        yearCombo.addItem(3);
        yearCombo.addItem(4);
        yearCombo.addItem(5);
        yearCombo.setBounds(520,145,165,20);
        panel.add(yearCombo);

        panel.repaint();

        JLabel success1 = new JLabel("Student added successfully!");
        success1.setVisible(false);
        success1.setBounds(730,100,200,20);
        panel.add(success1);
        JButton submit = new JButton("Submit");
        submit.setBounds(480,180,100,20);
        submit.setActionCommand("add");
        panel.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("add")) {
                    success1.setVisible(true);
                   String name = nameField.getText();
                   studentList.add(name);
                   String surname = surnameField.getText();
                   studentList.add(surname);
                   String selectedMajor = majorCombo.getSelectedItem().toString();
                   studentList.add(selectedMajor);
                   String selectedYear = yearCombo.getSelectedItem().toString();
                   studentList.add(selectedYear);


                }
            }
        });
    }
    public void showList(){
        for (String list : studentList) {
            System.out.println(list);

        }
    }

}
