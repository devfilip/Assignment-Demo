package org.launchcode;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends GUInterface {
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
    JFrame frame = new JFrame();
    JPanel addForm = new JPanel(new GridLayout(0,2,20,10));


    public FormPanel() {
        addForm.setBackground(Color.darkGray);
        addForm.setForeground(Color.WHITE);

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

        apply.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,"Student added succesfully!", "well done",
                    JOptionPane.INFORMATION_MESSAGE);
            Student newStudent = new Student(nameField.getText(),
                    surnameField.getText(),
                    (StudentsMajor) majorCombo.getSelectedItem(),
                    Integer.parseInt(yearField.getText()),
                    Double.parseDouble(avgField.getText()));
        });
    }

    public JPanel getAddForm() {
        return addForm;
    }
}
