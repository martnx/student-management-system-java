package gui;

import db.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.Element;

public class StudentForm extends JFrame implements ActionListener, DocumentListener{
	
	Database dataBase;
	
	JLabel titleLabel;
	
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
	
	JButton submitBtn;
	JButton cancelBtn;
	JLabel successInput;
	
	String firstNameContainer;
	String lastNameContainer;
	String ageContainer;
	String courseContainer;
	String unitsContainer;
	String instructorContainer;
	String gwaContainer;
	
	public StudentForm(){
		dataBase = new Database();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 700);
		this.setLayout(new BorderLayout());
		this.setResizable(false);

		int labelWidth = 100;
		int labelHeight = 50;
		
		int textFieldWidth = 250;
		int textFieldHeight = 35;
		
		titleLabel = new JLabel("Add Student Form");
		titleLabel.setSize(500, 40);
		titleLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(500,50));
		titlePanel.add(titleLabel);
		
		JPanel firstPanel = new JPanel();
		firstPanel.setPreferredSize(new Dimension(400,250));
//		firstPanel.setBackground(Color.cyan);
		firstPanel.setLayout(new FlowLayout());
		
		JPanel secondPanel = new JPanel();
		secondPanel.setPreferredSize(new Dimension(400,250));
//		secondPanel.setBackground(Color.red);
		secondPanel.setLayout(new FlowLayout());
		
		fnLabel = new JLabel("First Name");
		fnLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
		firstName = new JTextField();
		firstName.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
		
		lnLabel = new JLabel("Last Name");
		lnLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
		lastName = new JTextField();
		lastName.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

		ageLabel = new JLabel("Age");
		ageLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
		age = new JTextField();
		age.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
		
		courseLabel = new JLabel("Course");
		courseLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
		course = new JTextField();
		course.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
		
		unitsLabel = new JLabel("Units");
		unitsLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
		units = new JTextField();
		units.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
		
		instructorLabel = new JLabel("Instructor");
		instructorLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
		instructor = new JTextField();
		instructor.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
		
		gwaLabel = new JLabel("Gwa");
		gwaLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
		gwa = new JTextField();
		gwa.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
		
		gwaLabel = new JLabel("Gwa");
		gwaLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
		gwa = new JTextField();
		gwa.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
		
		submitBtn = new JButton("Submit");
		submitBtn.setPreferredSize(new Dimension(150, 30));
		submitBtn.addActionListener(this);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setPreferredSize(new Dimension(150, 30));
		cancelBtn.addActionListener(this);
		
		successInput = new JLabel("Successfully Registered");
		successInput.setPreferredSize(new Dimension(150, 30));
		
		submitBtn.setEnabled(false);
		firstName.getDocument().addDocumentListener(this);
		lastName.getDocument().addDocumentListener(this);
		age.getDocument().addDocumentListener(this);
		course.getDocument().addDocumentListener(this);
		units.getDocument().addDocumentListener(this);
		instructor.getDocument().addDocumentListener(this);
		gwa.getDocument().addDocumentListener(this);
		
		
		firstPanel.add(fnLabel);
		firstPanel.add(firstName);
		
		firstPanel.add(lnLabel);
		firstPanel.add(lastName);
		
		firstPanel.add(ageLabel);		
		firstPanel.add(age);
		
		firstPanel.add(courseLabel);
		firstPanel.add(course);
		//second panel
		secondPanel.add(unitsLabel);
		secondPanel.add(units);
		
		secondPanel.add(instructorLabel);
		secondPanel.add(instructor);
		
		secondPanel.add(gwaLabel);
		secondPanel.add(gwa);

		secondPanel.add(submitBtn);
		secondPanel.add(cancelBtn);
		
		secondPanel.add(successInput);
		successInput.setVisible(false);
		this.add(titlePanel,BorderLayout.NORTH);
		this.add(firstPanel,BorderLayout.WEST);
		this.add(secondPanel,BorderLayout.EAST);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	//action performed for buttons
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == submitBtn) {
			submitButton();
		}
		if(e.getSource()==cancelBtn) {
			this.dispose();
		}
	}
	
	
	void checkValidate() {
		if((firstName.getText().length()==0) || (lastName.getText().length()==0) || (age.getText().length()==0) || (course.getText().length()==0) || (units.getText().length()==0) || (instructor.getText().length()==0) || (gwa.getText().length()==0)) {
			submitBtn.setEnabled(false);
			System.out.println("true");
		}else {

			submitBtn.setEnabled(true);
		}
		
	}
	
	void submitButton()
	{
		dataBase.addStudents(firstNameContainer, lastNameContainer, courseContainer, unitsContainer, instructorContainer, gwaContainer);

		submitBtn.setEnabled(false);
		successInput.setVisible(true);

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		firstNameContainer = firstName.getText();
		lastNameContainer = lastName.getText();
		ageContainer = age.getText();
		courseContainer = course.getText();
		unitsContainer = units.getText();
		instructorContainer = instructor.getText();
		gwaContainer = gwa.getText();
		checkValidate();

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		System.out.println("Remove Update");
		firstNameContainer = firstName.getText();
		lastNameContainer = lastName.getText();
		ageContainer = age.getText();
		courseContainer = course.getText();
		unitsContainer = units.getText();
		instructorContainer = instructor.getText();
		gwaContainer = gwa.getText();
		checkValidate();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println("Changed Update!");
	}

}
