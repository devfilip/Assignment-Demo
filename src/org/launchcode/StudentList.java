package org.launchcode;

import javax.swing.*;
import java.awt.*;

public class StudentList extends GUInterface {

    JTable table;
    JPanel panel = new JPanel();
    public StudentList() {
        panel.setLayout(new FlowLayout());
        String[] header = {"Name", "Surname", "Major", "Year of Study", "Avg grade"};

        Object[][] data = {
                {"Filip", "Kiraga", "IT", "", ""},
                {"Marry", "Black", "Female", "", ""},
        };

        table = new JTable(data, header);
        table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);

        JScrollPane pane = new JScrollPane(table);
        panel.add(pane);


    }

    public JPanel getPanel() {
        return panel;
    }
}