package org.launchcode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    DefaultTableModel model;


    public FormPanel(DefaultTableModel model) {
        this.model = model;

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

            createStudent();
        });
    }

    public void createStudent(){
        Object[] row = new Object[5];

        row[0] = nameField.getText();
        row[1] = surnameField.getText();
        row[2] = majorCombo.getSelectedItem();
        row[3] =  yearField.getText();
        row[4] = avgField.getText();

        model.addRow(row);
    }

    public JPanel getAddForm() {
        return addForm;
    }
}
