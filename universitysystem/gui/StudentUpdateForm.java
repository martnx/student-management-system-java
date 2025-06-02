package gui;

import db.Database;
import model.Student;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentUpdateForm extends JFrame implements ActionListener, DocumentListener {
    Database dataBase;
    List<Student> students;

    JPanel titlePanel;

    JLabel titleLabel;
    JLabel searchIDLabel;
    JTextField searchIDTextField;
    JButton searchButton;

    JButton cancelButton;

    JLabel errorLabel;

    //View all 2nd frame Variables
    JFrame fullInfoFrameSecondFrame = null;

    JPanel titlePanelSecondFrame;
    JPanel firstPanelSecondFrame;
    JPanel secondPanelSecondFrame;

    JLabel titleLabelSecondFrame;
    JLabel fnLabel;
    JLabel lnLabel;
    JLabel ageLabel;
    JLabel courseLabel;
    JLabel unitsLabel;
    JLabel instructorLabel;
    JLabel gwaLabel;

    JTextField firstNameTextField;
    JTextField lastNameTextField;
    JTextField ageTextField;
    JTextField courseTextField;
    JTextField unitsTextField;
    JTextField instructorTextField;
    JTextField gwaTextField;

    JButton firstNameEditButton;
    JButton lastNameEditButton;
    JButton ageEditButton;
    JButton courseEditButton;
    JButton unitsEditButton;
    JButton instructorEditButton;
    JButton gwaEditButton;

    JButton submitBtnSecondFrame;
    JButton cancelBtnSecondFrame;
    JLabel successInput;

    public StudentUpdateForm() {
        //Database connection
        dataBase = new Database();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(500, 700);
        this.setLayout(new BorderLayout());

        int labelWidth = 100;
        int labelHeight = 50;

        int textFieldWidth = 250;
        int textFieldHeight = 35;

        titleLabel = new JLabel("Student Update");
        titleLabel.setSize(500, 40);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 35));

        titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(400,75));
        titlePanel.add(titleLabel);

        firstPanelSecondFrame = new JPanel();
        firstPanelSecondFrame.setPreferredSize(new Dimension(400,170));
        firstPanelSecondFrame.setLayout(new FlowLayout());

        searchIDLabel = new JLabel("Search ID: ");
        searchIDLabel.setPreferredSize(new Dimension(labelWidth, labelHeight));

        searchIDTextField = new JTextField();
        searchIDTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(labelWidth, 30));
        searchButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(labelWidth, 30));
        cancelButton.addActionListener(this);

        errorLabel = new JLabel("User does not exist.");
        errorLabel.setPreferredSize(new Dimension(200, labelHeight));
        errorLabel.setHorizontalAlignment(JLabel.CENTER);

        firstPanelSecondFrame.add(searchIDLabel);
        firstPanelSecondFrame.add(searchIDTextField);
        firstPanelSecondFrame.add(searchButton);
        firstPanelSecondFrame.add(cancelButton);

        this.add(firstPanelSecondFrame);
        this.add(titlePanel, BorderLayout.NORTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void fullInfoFrame(){
        int labelWidth = 100;
        int labelHeight = 50;

        int textFieldWidth = 250;
        int textFieldHeight = 35;

        fullInfoFrameSecondFrame = new JFrame();
        fullInfoFrameSecondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fullInfoFrameSecondFrame.setSize(500, 700);
        fullInfoFrameSecondFrame.setLayout(new BorderLayout());
        fullInfoFrameSecondFrame.setResizable(false);

        titleLabelSecondFrame = new JLabel("Student Update Form");
        titleLabelSecondFrame.setSize(500, 40);
        titleLabelSecondFrame.setFont(new Font("Serif", Font.PLAIN, 25));

        titlePanelSecondFrame = new JPanel();
        titlePanelSecondFrame.setPreferredSize(new Dimension(500,50));
        titlePanelSecondFrame.add(titleLabelSecondFrame);

        firstPanelSecondFrame = new JPanel();
        firstPanelSecondFrame.setPreferredSize(new Dimension(500,250));
//		firstPanel.setBackground(Color.cyan);
        firstPanelSecondFrame.setLayout(new FlowLayout());

        secondPanelSecondFrame = new JPanel();
        secondPanelSecondFrame.setPreferredSize(new Dimension(500,250));
//		secondPanel.setBackground(Color.red);
        secondPanelSecondFrame.setLayout(new FlowLayout());

        fnLabel = new JLabel("First Name");
        fnLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));

        firstNameTextField = new JTextField();
        firstNameTextField.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        firstNameEditButton = new JButton("Edit");
        firstNameEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        lnLabel = new JLabel("Last Name");
        lnLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));

        lastNameTextField = new JTextField();
        lastNameTextField.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        lastNameEditButton = new JButton("Edit");
        lastNameEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        ageLabel = new JLabel("Age");
        ageLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));

        ageTextField = new JTextField();
        ageTextField.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        ageEditButton = new JButton("Edit");
        ageEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        courseLabel = new JLabel("Course");
        courseLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));

        courseTextField = new JTextField();
        courseTextField.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        courseEditButton = new JButton("Edit");
        courseEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        unitsLabel = new JLabel("Units");
        unitsLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));

        unitsTextField = new JTextField();
        unitsTextField.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        unitsEditButton = new JButton("Edit");
        unitsEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        instructorLabel = new JLabel("Instructor");
        instructorLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));

        instructorTextField = new JTextField();
        instructorTextField.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        instructorEditButton = new JButton("Edit");
        instructorEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        gwaLabel = new JLabel("Gwa");
        gwaLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));

        gwaTextField = new JTextField();
        gwaTextField.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        gwaLabel = new JLabel("Gwa");
        gwaLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));

        gwaEditButton = new JButton("Edit");
        gwaEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        submitBtnSecondFrame = new JButton("Submit");
        submitBtnSecondFrame.setPreferredSize(new Dimension(150, 30));
        submitBtnSecondFrame.addActionListener(this);

        cancelBtnSecondFrame = new JButton("Cancel");
        cancelBtnSecondFrame.setPreferredSize(new Dimension(150, 30));
        cancelBtnSecondFrame.addActionListener(this);

        successInput = new JLabel("Successfully Registered");
        successInput.setPreferredSize(new Dimension(150, 30));

        //ActionListener
        firstNameEditButton.addActionListener(this);
        lastNameEditButton.addActionListener(this);
        ageEditButton.addActionListener(this);
        courseEditButton.addActionListener(this);
        unitsEditButton.addActionListener(this);
        instructorEditButton.addActionListener(this);
        gwaEditButton.addActionListener(this);
        submitBtnSecondFrame.addActionListener(this);
        cancelBtnSecondFrame.addActionListener(this);


        //DocumentListener
        firstNameTextField.getDocument().addDocumentListener(this);
        lastNameTextField.getDocument().addDocumentListener(this);
        ageTextField.getDocument().addDocumentListener(this);
        courseTextField.getDocument().addDocumentListener(this);
        unitsTextField.getDocument().addDocumentListener(this);
        instructorTextField.getDocument().addDocumentListener(this);
        gwaTextField.getDocument().addDocumentListener(this);

        //All textfield must be disabled
        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        ageTextField.setEditable(false);
        courseTextField.setEditable(false);
        unitsTextField.setEditable(false);
        instructorTextField.setEditable(false);
        gwaTextField.setEditable(false);

        firstPanelSecondFrame.add(fnLabel);
        firstPanelSecondFrame.add(firstNameTextField);
        firstPanelSecondFrame.add(firstNameEditButton);

        firstPanelSecondFrame.add(lnLabel);
        firstPanelSecondFrame.add(lastNameTextField);
        firstPanelSecondFrame.add(lastNameEditButton);

        firstPanelSecondFrame.add(ageLabel);
        firstPanelSecondFrame.add(ageTextField);
        firstPanelSecondFrame.add(ageEditButton);

        firstPanelSecondFrame.add(courseLabel);
        firstPanelSecondFrame.add(courseTextField);
        firstPanelSecondFrame.add(courseEditButton);

        //second panel
        secondPanelSecondFrame.add(unitsLabel);
        secondPanelSecondFrame.add(unitsTextField);
        secondPanelSecondFrame.add(unitsEditButton);

        secondPanelSecondFrame.add(instructorLabel);
        secondPanelSecondFrame.add(instructorTextField);
        secondPanelSecondFrame.add(instructorEditButton);

        secondPanelSecondFrame.add(gwaLabel);
        secondPanelSecondFrame.add(gwaTextField);
        secondPanelSecondFrame.add(gwaEditButton);

        secondPanelSecondFrame.add(submitBtnSecondFrame);
        secondPanelSecondFrame.add(cancelBtnSecondFrame);

        secondPanelSecondFrame.add(successInput);

        fullInfoFrameSecondFrame.add(titlePanelSecondFrame,BorderLayout.NORTH);
        fullInfoFrameSecondFrame.add(firstPanelSecondFrame,BorderLayout.WEST);
        fullInfoFrameSecondFrame.add(secondPanelSecondFrame,BorderLayout.EAST);
        fullInfoFrameSecondFrame.pack();
        fullInfoFrameSecondFrame.setLocationRelativeTo(null);
        fullInfoFrameSecondFrame.setVisible(true);
    }

    boolean isNumber(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            System.out.println(e);
            return false;
        }
    }

    public void displayDatainTextField(int person_id) {

        List<Student> students = dataBase.loadStudents();
        boolean isFound = false;
        for(Student student : students) {
            if (student.getId() == person_id) {
                fullInfoFrame();
                firstNameTextField.setText(student.getFirstName());
                lastNameTextField.setText(student.getLastName());
                ageTextField.setText(String.valueOf(student.getAge()));
                courseTextField.setText(String.valueOf(student.getCourse()));
                unitsTextField.setText(String.valueOf(student.getUnits()));
                instructorTextField.setText(String.valueOf(student.getInstructor()));
                gwaTextField.setText(String.valueOf(student.getGwa()));

                isFound = true;
                fullInfoFrameSecondFrame.setVisible(true);

            }
        }
        if(!isFound){
            errorLabel.setText("No Student ID Found");
            firstPanelSecondFrame.add(errorLabel);
            firstPanelSecondFrame.revalidate(); // Add these
            firstPanelSecondFrame.repaint();
        }
    }

    void searchButton(){
        String searchID = searchIDTextField.getText();
        if(isNumber(searchID)) {
            int person_ID = Integer.parseInt(searchID);
            displayDatainTextField(person_ID);
        }
        else{
            errorLabel.setText("Invalid Input");
            System.out.println("Search ID is empty.");
            firstPanelSecondFrame.add(errorLabel);
            firstPanelSecondFrame.revalidate(); // Add these
            firstPanelSecondFrame.repaint();
        }

    }

    //ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton) {
            searchButton();

        }
        if(e.getSource() == cancelButton) {
            this.dispose();
        }

        if(e.getSource() == cancelBtnSecondFrame){
            fullInfoFrameSecondFrame.dispose();
        }

        if(e.getSource() == firstNameEditButton){
            firstNameTextField.setEditable(true);
        }

        if(e.getSource() == lastNameEditButton){
            lastNameTextField.setEditable(true);
        }

        if(e.getSource() == ageEditButton){
            ageTextField.setEditable(true);
        }

        if(e.getSource() == courseEditButton){
            courseTextField.setEditable(true);
        }

        if(e.getSource() == unitsEditButton){
            unitsTextField.setEditable(true);
        }

        if(e.getSource() == instructorEditButton){
            instructorTextField.setEditable(true);
        }

        if(e.getSource() == gwaEditButton){
            gwaTextField.setEditable(true);
        }

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println(e.getDocument().getLength());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
