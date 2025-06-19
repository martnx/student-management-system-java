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

    Database database;
    List<Student> studentList;

    JPanel titlePanel;
    JLabel titleLabel;

    JPanel centerPanel;
    JPanel firstPanel;
    JPanel secondPanel;

    JTextField searchTextField;
    JButton submitSearchButton;

    JLabel sortByLabel;
    JComboBox<String> searchByComboBox;

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    public StudentListView1()
    {
        this.setTitle("Student List");
        this.setSize(900, 400);
        this.setLayout(new BorderLayout());

        titlePanel = new JPanel();
        titlePanel.setSize(800, 100);
//        titlePanel.setBackground(Color.red);

        titleLabel = new JLabel("Student List");
        titleLabel.setSize(800, 40);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 35));

        firstPanel = new JPanel();
        firstPanel.setPreferredSize(new Dimension(400, 300));
//        firstPanel.setBackground(Color.cyan);

        secondPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        secondPanel.setPreferredSize(new Dimension(500, 300));
        secondPanel.setBackground(Color.lightGray);

        //Search TextField
        searchTextField = new JTextField();
        searchTextField.setPreferredSize(new Dimension(200, 30));
        searchTextField.getDocument().addDocumentListener(this);

        submitSearchButton = new JButton("Search");
        submitSearchButton.setPreferredSize(new Dimension(100, 30));
        submitSearchButton.addActionListener(this);

        //Search by ComboBox
        String[] searchBy = {"ID", "Name", "Age", "Course", "Units", "Instructor", "GWA"};
        searchByComboBox = new JComboBox<>(searchBy);
        searchByComboBox.setPreferredSize(new Dimension(150, 30));
        searchByComboBox.addActionListener(this);

        sortByLabel = new JLabel("Sort By");
        sortByLabel.setPreferredSize(new Dimension(100, 30));

        firstPanel.add(searchTextField);
        firstPanel.add(submitSearchButton);
        firstPanel.add(sortByLabel);
        firstPanel.add(searchByComboBox);
        //To remove padding
//        FlowLayout flowLayout = (FlowLayout) secondPanel.getLayout();
//        flowLayout.setHgap(0);
//        flowLayout.setVgap(0);

        //ScrollPane and JTable - Initializing
        String[][] data =
        {
          {"01", "Juan Dela Cruz", "20", "Civil Engineering", "3", "Dr. Jimmy", "3.8"},
                {"01", "Juan Dela Cruz", "20", "Civil Engineering", "3", "Dr. Jimmy", "3.8"},
        };

        String[] columnNames = {"ID", "Name", "Age", "Course", "Units", "Instructor", "GWA"};

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        table = new JTable(tableModel);


        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        secondPanel.add(scrollPane);

        loadStudents();
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
        database = new Database();
        studentList = database.loadStudents();

        for (Student s : studentList)
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

    void searchById()
    {
        int searchId = Integer.parseInt(searchTextField.getText());
        System.out.println("Inserted: " + searchId);

        tableModel.setRowCount(0);

        studentList = database.loadStudents();

        for(Student student : studentList)
        {
            if(student.getId() == searchId)
            {
                System.out.println("Found: " + student.getId());
                tableModel.addRow(new Object[]{
                        student.getId(),
                        student.getFullName(),
                        student.getAge(),
                        student.getCourse(),
                        student.getUnits(),
                        student.getInstructor(),
                        student.getGwa()
                });
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submitSearchButton)
        {
            searchById();
        }
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
        System.out.println("Changed");
    }

    //For Slider
    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
