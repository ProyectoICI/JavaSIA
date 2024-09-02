package main.java.com.hospital.views.swing;

import javax.swing.*;

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
