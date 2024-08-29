package main.java.com.hospital.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel MainPanel;

    public MainFrame() {
        // Initialize components
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel.setSize(800, 600);
        pack();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
