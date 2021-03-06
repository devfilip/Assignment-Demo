package org.launchcode;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GUInterface{


    public static void createAndShowGui() {
        JFrame mainFrame = new JFrame("First assignment");

        JPanel menu = new JPanel(new FlowLayout());

        StudentList table = new StudentList(); //obiekt listy studentow
        FormPanel addForm = new FormPanel(table.getModel());

        //dodawanie przyciskow do panelu menu
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
        table.readFile(); //wczytywanie danych z pliku tekstowego

        addStudent.addActionListener(e -> {   //akcja na przycisku dodająca do ramki panel z formularzem dodawania studenta
            mainFrame.add(addForm.getAddForm(),BorderLayout.CENTER);
            mainFrame.revalidate();

        });

        showStudents.addActionListener(e -> {   //listener wyswietlajacy liste studentów
            mainFrame.add(table.getPanel(), BorderLayout.SOUTH);
            mainFrame.revalidate();
        });

        modifyStudent.addActionListener(e -> {
            if (table.getModel().getRowCount() == 0){   //walidacja czy lista studentow jest pusta
                JOptionPane.showMessageDialog(null,"Student list is empty.", "ERROR",JOptionPane.ERROR_MESSAGE);
            }else if (table.table.getSelectionModel().isSelectionEmpty() ){  //walidacja czy jest zaznaczony jakis wiersz w tabeli
                JOptionPane.showMessageDialog(null,"Select a student you want to edit.","ERROR",JOptionPane.ERROR_MESSAGE);
            } else {
                table.updateRow();
            }
        });

        deleteStudent.addActionListener(e -> {
            if (table.table.getSelectionModel().isSelectionEmpty()){   //walidacja czy jest zaznaczony wiersz do usuniecia
                JOptionPane.showMessageDialog(null,"Select a student you want to remove.","ERROR",JOptionPane.ERROR_MESSAGE);
            }else {
                table.delRow();
                JOptionPane.showMessageDialog(mainFrame, "Student deleted succesfully!", "well done",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        searchStudent.addActionListener(e -> {
            JFrame frame = new JFrame("Search student");
            JPanel search = new JPanel(new FlowLayout());
            JTextField searchBar = new JTextField(20);


            search.add(searchBar);
            search.add(table.getPanel());

            searchBar.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    String text = searchBar.getText().toUpperCase();

                    table.filter(text);
                }
            });

            TableRowSorter sorter = new TableRowSorter(table.model);
            sorter.setRowFilter(RowFilter.regexFilter(searchBar.getText()));
            table.table.setRowSorter(sorter);

            frame.setContentPane(search);
            Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setSize(screenDim.width / 2,screenDim.height / 2);
            frame.setLocation(screenDim.width / 3, screenDim.height / 3);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   // window closing when click on Exit button
            frame.setVisible(true);
        });



        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();      // setting window size
        mainFrame.setSize(screenDim.width / 2,screenDim.height / 2);
        mainFrame.setLocation(screenDim.width / 4, screenDim.height / 4);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // window closing when click on Exit button
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.darkGray);


    }



}

