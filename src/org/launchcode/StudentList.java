package org.launchcode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

public class StudentList extends GUInterface {

    JPanel panel = new JPanel();
    DefaultTableModel model = new DefaultTableModel(); //
    JTable table = new JTable(model);

    public StudentList() {
        panel.setLayout(new FlowLayout());

        Object[] columns = {"Name", "Surname","Major","Year of study", "Avg. Grade"};     //nazwy kolumn tabeli

        model.setColumnIdentifiers(columns);
        table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);  //rozciaga tabele do maksymalnej wielkosci

        JScrollPane pane = new JScrollPane(table);
        panel.add(pane);




    }
    public JPanel getPanel() {
        return panel;
    }

    public void filter (String query){                  //metoda, ktora sortuje z pola tekstowego
        TableRowSorter tr = new TableRowSorter(model);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void delRow() {          //metoda, sluzaca do usuwania zaznaczonego wiersza

        if (selectedRow != -1) {
            int modelIndex = table.convertRowIndexToModel(selectedRow);
            model.removeRow(modelIndex);
        }
    }

    public void updateRow(){                //metoda, sluzaca do modyfikowania danych studenta w wierszu
        int selectedRow = table.getSelectedRow();

        //pobieranie wartosci z komorek w wierszu
        String name = model.getValueAt(selectedRow, 0).toString();
        String surname = model.getValueAt(selectedRow, 1).toString();
        String major = model.getValueAt(selectedRow, 2).toString();
        String year = model.getValueAt(selectedRow, 3).toString();
        String avg = model.getValueAt(selectedRow, 4).toString();

            //modyfikowanie kolejno komórek w wierszu
        String newName = JOptionPane.showInputDialog(null,"Enter Name",name);
        String newSurname = JOptionPane.showInputDialog(null,"Enter Surname",surname);
        String newMajor = JOptionPane.showInputDialog(null,"Enter Major",major);
        String newYear = JOptionPane.showInputDialog(null,"Enter Year of Study",year);
        String newAvg = JOptionPane.showInputDialog(null,"Enter Average grade",avg);



        //ustawianie wartosci komorek w wierszu
        model.setValueAt(newName.toUpperCase(),selectedRow,0);
        model.setValueAt(newSurname.toUpperCase(),selectedRow,1);
        model.setValueAt(newMajor.toUpperCase(),selectedRow,2);
        model.setValueAt(newYear.toUpperCase(),selectedRow,3);
        model.setValueAt(newAvg.toUpperCase(),selectedRow,4);
    }

    //metoda odczytujaca dane tabeli z pliku tekstowego
    public void readFile(){
        String line;
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("table.txt"));
            while((line = reader.readLine()) != null)
            {
                model.addRow(line.split(" ; "));
            }
            reader.close();
        }
        catch(IOException ex) {
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();

        }
    }
}