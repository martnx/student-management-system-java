package gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import db.Database;
import model.Student;

public class StudentListView1 extends JFrame implements ActionListener, DocumentListener, ChangeListener
{

    JPanel titlePanel;
    JLabel titleLabel;

    JPanel centerPanel;
    JPanel firstPanel;
    JPanel secondPanel;

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    public StudentListView1()
    {
        this.setTitle("Student List");
        this.setSize(800, 400);
        this.setLayout(new BorderLayout());

        titlePanel = new JPanel();
        titlePanel.setSize(800, 100);
        titlePanel.setBackground(Color.red);

        titleLabel = new JLabel("Student List");
        titleLabel.setSize(800, 40);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 35));

        firstPanel = new JPanel();
        firstPanel.setPreferredSize(new Dimension(300, 300));
        firstPanel.setBackground(Color.cyan);

        secondPanel = new JPanel();
        secondPanel.setPreferredSize(new Dimension(500, 300));
        secondPanel.setBackground(Color.lightGray);

        //ScrollPane and JTable - Initializing
        String[][] data =
        {
          {"01", "Juan Dela Cruz", "20", "Civil Engineering", "3", "Dr. Jimmy", "3.8"},
        };

        String[] columnNames = {"ID", "Name", "Age", "Course", "Units", "Instructor", "GWA"};


        table = new JTable(data, columnNames);

        scrollPane = new JScrollPane(table);
        secondPanel.add(scrollPane);


        titlePanel.add(titleLabel);

        this.add(secondPanel, BorderLayout.EAST);
        this.add(firstPanel, BorderLayout.WEST);
        this.add(titlePanel, BorderLayout.NORTH);

//        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    private void loadStudents()
    {
        Database db = new Database();
        List<Student> students = db.loadStudents();

        for (Student s : students)
        {
            tableModel.addRow(new Object[]{
                    s.getId(),
                    s.getFullName(),
                    s.getAge(),
                    s.getCourse(),
                    s.getUnits(),
                    s.getInstructor(),
                    s.getGwa()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {

    }

    @Override
    public void removeUpdate(DocumentEvent e){

    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {

    }

    //For Slider
    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
