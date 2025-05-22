package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import db.Database;
import model.Student;

public class StudentListView extends JFrame{
    private JTable table;
    private DefaultTableModel tableModel;

    public StudentListView() {
        setTitle("Student List");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Define table headers
        tableModel.setColumnIdentifiers(new String[] {
            "ID", "Name", "Age", "Course", "Units", "Instructor", "GWA"
        });

        add(scrollPane, BorderLayout.CENTER);

        loadStudents(); // Load data from database

        setVisible(true);
    }
    private void loadStudents() {
        Database db = new Database(); // use your existing DB utility
        List<Student> students = db.loadStudents(); // make sure this returns a List<Student>

        for (Student s : students) {
            tableModel.addRow(new Object[] {
                s.getId(),
                s.getFullName(),
                s.getAge(),
                s.getCourse(),
                s.getUnits(),
//                s.getInstructor(),
                s.getGwa()
            });
        }
    }
}
