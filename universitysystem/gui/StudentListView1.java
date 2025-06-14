package gui;

import javax.swing.*;
import java.awt.*;

public class StudentListView1 extends JFrame {

    JPanel titlePanel;
    JLabel titleLabel;

    JPanel firstPanel;

    JLabel enterIDLabel;
    JTextField studentIDTextField;
    JButton deleteButton;
    JButton cancelButton;
    JLabel successLabel;
    JLabel errorLabel;
    JLabel userDeletedLabel;

    public StudentListView1() {
        this.setTitle("Student List");
        this.setSize(800, 400);

        titlePanel = new JPanel();
        titlePanel.setSize(800, 100);
        titlePanel.setBackground(Color.red);

        titleLabel = new JLabel("Student List");
        titleLabel.setSize(800, 40);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 35));

        firstPanel = new JPanel();
        firstPanel.setSize(800, 300);
        firstPanel.setBackground(Color.cyan);


        titlePanel.add(titleLabel);

        this.add(firstPanel, BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.NORTH);

//        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
