package org.launchcode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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

        nameLabel.setForeground(Color.white);
        surnameLabel.setForeground(Color.white);
        majorLabel.setForeground(Color.white);
        yearLabel.setForeground(Color.white);
        avgLabel.setForeground(Color.white);

        addForm.setBackground(Color.darkGray);

        addForm.add(nameLabel);
        addForm.add(nameField);

        addForm.add(surnameLabel);
        addForm.add(surnameField);

        addForm.add(majorLabel);
        addForm.add(majorCombo);

        addForm.add(yearLabel);
        addForm.add(yearField);
        yearField.addKeyListener(new KeyAdapter() { //keylistener ktory zabrania uzytkownikowi wprowadzania znaków innych niz liczby w pole tekstowe
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!   ((c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)
                        ||  (c== KeyEvent.VK_ENTER)      || (c == KeyEvent.VK_TAB)
                        ||  (Character.isDigit(c))))
                {
                    JOptionPane.showMessageDialog(frame,"Only numbers are allowed here!");
                    e.consume();
                }
            }
        });

        addForm.add(avgLabel);
        addForm.add(avgField);
        avgField.addKeyListener(new KeyAdapter() {  //ten sam keylistener co wyzej
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!   ((c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)
                        ||  (c== KeyEvent.VK_ENTER)      || (c == KeyEvent.VK_TAB)
                        ||  (Character.isDigit(c))))
                {
                    JOptionPane.showMessageDialog(frame,"Only numbers are allowed here!");
                    e.consume();
                }
            }
        });

        addForm.add(empty);
        addForm.add(apply);


        apply.addActionListener(e -> {
            //warunek sprawdzajacy czy wszystkie pola zostaly wypelnione, jezeli nie, wyskakuje błąd
            if (nameField.getText().isEmpty() || surnameField.getText().isEmpty() || yearField.getText().isEmpty() || avgField.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame,"Please enter all the fields", "ERROR",JOptionPane.INFORMATION_MESSAGE);
            }else {
                createStudent();
                nameField.setText("");
                surnameField.setText("");
                yearField.setText("");
                avgField.setText("");

                JOptionPane.showMessageDialog(frame, "Student added succesfully!", "well done",
                        JOptionPane.INFORMATION_MESSAGE);

                //zapis do pliku tekstowego
                try {
                    File file = new File("table.txt");

                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    for (int row = 0; row < model.getRowCount(); row++) {
                        for (int col = 0; col < model.getColumnCount(); col++) {
                            bw.write(model.getValueAt(row, col) + " ");
                        }

                        bw.write("\n");
                    }
                    //close BufferedWriter
                    bw.close();
                    //close FileWriter
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Data Exported");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

    }
    //metoda tworzaca obiekt studenta i dodajaca do modelu tabeli jako wiersz
    public void createStudent(){
        Object[] row = new Object[5];

        row[0] = nameField.getText().toUpperCase();
        row[1] = surnameField.getText().toUpperCase();
        row[2] = majorCombo.getSelectedItem().toString().toUpperCase();
        row[3] =  yearField.getText().toUpperCase();
        row[4] = avgField.getText().toUpperCase();

        model.addRow(row);
    }

    public JPanel getAddForm() {
        return addForm;
    }
}
