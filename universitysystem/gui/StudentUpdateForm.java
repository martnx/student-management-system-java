package gui;

import db.Database;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentUpdateForm extends JFrame implements ActionListener, DocumentListener {
    Database dataBase;

    JPanel titlePanel;
    JPanel firstPanelSecondFrame;

    JLabel titleLabel;
    JLabel searchIDLabel;
    JTextField searchIDTextField;
    JButton searchButton;

    JButton cancelButton;

    JLabel errorLabel;

    JFrame fullInfoFrame;

    //View all frame Variables
    JFrame fullInfoFrameSecondFrame;

    JLabel titleLabelSecondFrame;

    JLabel fnLabel;
    JLabel lnLabel;
    JLabel ageLabel;
    JLabel courseLabel;
    JLabel unitsLabel;
    JLabel instructorLabel;
    JLabel gwaLabel;

    JTextField firstName;
    JTextField lastName;
    JTextField age;
    JTextField course;
    JTextField units;
    JTextField instructor;
    JTextField gwa;

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

    boolean isNumber(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            System.out.println(e);
            return false;
        }
    }

    void viewAllDataFrame() {



    }

    public void fullInfoFrame(){
        dataBase = new Database();



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

        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(500,50));
        titlePanel.add(titleLabelSecondFrame);

        JPanel firstPanelSecondFrame = new JPanel();
        firstPanelSecondFrame.setPreferredSize(new Dimension(500,250));
//		firstPanel.setBackground(Color.cyan);
        firstPanelSecondFrame.setLayout(new FlowLayout());

        JPanel secondPanelSecondFrame = new JPanel();
        secondPanelSecondFrame.setPreferredSize(new Dimension(500,250));
//		secondPanel.setBackground(Color.red);
        secondPanelSecondFrame.setLayout(new FlowLayout());

        fnLabel = new JLabel("First Name");
        fnLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));

        firstName = new JTextField();
        firstName.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
        firstName.setText("This is testing");
        firstName.setEditable(false);

        firstNameEditButton = new JButton("Edit");
        firstNameEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        lnLabel = new JLabel("Last Name");
        lnLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
        lastName = new JTextField();
        lastName.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        lastNameEditButton = new JButton("Edit");
        lastNameEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        ageLabel = new JLabel("Age");
        ageLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
        age = new JTextField();
        age.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        ageEditButton = new JButton("Edit");
        ageEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        courseLabel = new JLabel("Course");
        courseLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
        course = new JTextField();
        course.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        courseEditButton = new JButton("Edit");
        courseEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        unitsLabel = new JLabel("Units");
        unitsLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
        units = new JTextField();
        units.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        unitsEditButton = new JButton("Edit");
        unitsEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        instructorLabel = new JLabel("Instructor");
        instructorLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
        instructor = new JTextField();
        instructor.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        instructorEditButton = new JButton("Edit");
        instructorEditButton.setPreferredSize(new Dimension(65, textFieldHeight));

        gwaLabel = new JLabel("Gwa");
        gwaLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
        gwa = new JTextField();
        gwa.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

        gwaLabel = new JLabel("Gwa");
        gwaLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
        gwa = new JTextField();
        gwa.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

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

        cancelBtnSecondFrame.setEnabled(false);
        firstName.getDocument().addDocumentListener(this);
        lastName.getDocument().addDocumentListener(this);
        age.getDocument().addDocumentListener(this);
        course.getDocument().addDocumentListener(this);
        units.getDocument().addDocumentListener(this);
        instructor.getDocument().addDocumentListener(this);
        gwa.getDocument().addDocumentListener(this);

        firstPanelSecondFrame.add(fnLabel);
        firstPanelSecondFrame.add(firstName);
        firstPanelSecondFrame.add(firstNameEditButton);

        firstPanelSecondFrame.add(lnLabel);
        firstPanelSecondFrame.add(lastName);
        firstPanelSecondFrame.add(lastNameEditButton);

        firstPanelSecondFrame.add(ageLabel);
        firstPanelSecondFrame.add(age);
        firstPanelSecondFrame.add(ageEditButton);

        firstPanelSecondFrame.add(courseLabel);
        firstPanelSecondFrame.add(course);
        firstPanelSecondFrame.add(courseEditButton);

        //second panel
        secondPanelSecondFrame.add(unitsLabel);
        secondPanelSecondFrame.add(units);
        secondPanelSecondFrame.add(unitsEditButton);

        secondPanelSecondFrame.add(instructorLabel);
        secondPanelSecondFrame.add(instructor);
        secondPanelSecondFrame.add(instructorEditButton);

        secondPanelSecondFrame.add(gwaLabel);
        secondPanelSecondFrame.add(gwa);
        secondPanelSecondFrame.add(gwaEditButton);

        secondPanelSecondFrame.add(submitBtnSecondFrame);
        secondPanelSecondFrame.add(cancelBtnSecondFrame);

        secondPanelSecondFrame.add(successInput);

        fullInfoFrameSecondFrame.add(titleLabelSecondFrame,BorderLayout.NORTH);
        fullInfoFrameSecondFrame.add(firstPanelSecondFrame,BorderLayout.WEST);
        fullInfoFrameSecondFrame.add(secondPanelSecondFrame,BorderLayout.EAST);
        fullInfoFrameSecondFrame.pack();
        fullInfoFrameSecondFrame.setLocationRelativeTo(null);
        fullInfoFrameSecondFrame.setVisible(true);
    }

    void searchButton(){
        String searchID = searchIDTextField.getText();
        if(isNumber(searchID)) {
            int person_ID = Integer.parseInt(searchID);
//            viewAllDataFrame(person_ID);
//            System.out.println("TEST");


        }
        else{
            errorLabel.setText("Invalid Input");
            System.out.println("Search ID is empty.");
            firstPanelSecondFrame.add(errorLabel);
            firstPanelSecondFrame.revalidate(); // Add these
            firstPanelSecondFrame.repaint();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton) {
            searchButton();
            fullInfoFrame();

        }
        if(e.getSource() == cancelButton) {
            this.dispose();
        }

//        if(e.getSource() == firstNameEditButton)


    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
