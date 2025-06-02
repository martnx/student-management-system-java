package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import db.Database;

public class StudentDeleteForm extends JFrame implements ActionListener, DocumentListener{

	Database dataBase;
	
	JPanel titlePanel;
	JPanel firstPanel;
	
	JLabel titleLabel;
	JLabel enterIDLabel;
	
	JTextField studentIDTextField;
	
	JButton deleteButton;
	JButton cancelButton;
	
	JLabel successLabel;
	JLabel errorLabel; 
	JLabel userDeletedLabel;
	
	public StudentDeleteForm(){
		dataBase = new Database();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 700);
		this.setLayout(new BorderLayout());
		this.setResizable(false);

		int labelWidth = 100;
		int labelHeight = 50;
		
		int textFieldWidth = 250;
		int textFieldHeight = 35;

		titleLabel = new JLabel("Delete Student");
		titleLabel.setSize(500, 40);
		titleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		
		titlePanel = new JPanel();
//		titlePanel.setBackground(Color.red);
		titlePanel.setPreferredSize(new Dimension(450,50));
		titlePanel.add(titleLabel);
		
		firstPanel = new JPanel();
//		firstPanel.setBackground(Color.cyan);
		firstPanel.setPreferredSize(new Dimension(450,160));
		firstPanel.setLayout(new FlowLayout());
		
		enterIDLabel = new JLabel("Enter Student ID");
		enterIDLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
		
		studentIDTextField = new JTextField();
		studentIDTextField.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));

		deleteButton = new JButton("Delete");
		deleteButton.setPreferredSize(new Dimension(150, 30));
		deleteButton.addActionListener(this);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setPreferredSize(new Dimension(150, 30));
		cancelButton.addActionListener(this);
		
		successLabel = new JLabel("Successfully deleted");
		successLabel.setPreferredSize(new Dimension(150, 30));
		
		userDeletedLabel = new JLabel("");
		userDeletedLabel.setPreferredSize(new Dimension(120, 30));
		
		errorLabel = new JLabel("Student id doesn't existed");
		errorLabel.setPreferredSize(new Dimension(150, 30));
		
		firstPanel.add(enterIDLabel);
		firstPanel.add(studentIDTextField);
		firstPanel.add(deleteButton);
		firstPanel.add(cancelButton);
		
		firstPanel.add(successLabel);
		
		errorLabel.setVisible(false);
		userDeletedLabel.setVisible(false);
		successLabel.setVisible(false);
		
		this.add(firstPanel);
		this.add(titlePanel,BorderLayout.NORTH);
//		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deleteButton) {
			deleteStudent();
		}
		if(e.getSource() == cancelButton) {
			this.dispose();
		}
		
	}
	
	
	void deleteStudent() {
		String id = studentIDTextField.getText();
		String firstName = dataBase.deleteStudent(id);
		System.out.println(firstName);

		if(firstName == null || firstName.isBlank()) 
		{
			System.out.println("JLabel added");
			firstPanel.add(errorLabel);
			successLabel.setVisible(false);
			userDeletedLabel.setVisible(false);
			errorLabel.setVisible(true);
			return;
		}
		else
		{
			userDeletedLabel = new JLabel(firstName + " is deleted.");
			firstPanel.add(userDeletedLabel);
			errorLabel.setVisible(false);
			successLabel.setVisible(true);
			userDeletedLabel.setVisible(true);
		}

		

	}
		
		
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}



	
	
}
