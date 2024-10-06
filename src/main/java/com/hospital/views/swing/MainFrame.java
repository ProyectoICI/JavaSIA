package main.java.com.hospital.views.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel MainPanel;
    private JPanel contentPane;
    private JPanel buttonPane;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public MainFrame() {


        // Initialize components
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
