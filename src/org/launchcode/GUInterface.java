package org.launchcode;

import javax.swing.*;

public class GUInterface {

    public static void createAndShowGui() {
        JFrame mainFrame = new JFrame("First assignment");

        JPanel myPanel = new JPanel();

        JButton submit = new JButton("Submit"); //submit button object

        JTextField nameField = new JTextField(10);
        JLabel nameLabel = new JLabel("Name: ");
        myPanel.add(nameLabel); //just a label with a "name" text;
        myPanel.add(nameField); // name to fill with student's name
        myPanel.add(submit); // adding submit button to my panel


        mainFrame.setSize(500,500);
        mainFrame.setContentPane(myPanel);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}