package org.launchcode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentList extends GUInterface {

    JPanel panel = new JPanel();
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    public DefaultTableModel getModel() {
        return model;
    }

    public StudentList() {
        panel.setLayout(new FlowLayout());

        Object[] columns = {"Name", "Surname","Major","Year of study", "Avg. Grade"};

        model.setColumnIdentifiers(columns);
        table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);
        table.setEnabled(false);


        JScrollPane pane = new JScrollPane(table);
        panel.add(pane);


    }

    public JPanel getPanel() {
        return panel;
    }
}