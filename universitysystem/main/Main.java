package main;

import java.awt.FlowLayout;
import javax.swing.*;

import cli.ConsoleView;
import gui.*;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(StudentForm::new); // Launch the GUI
//		new StudentForm();
		
		
//		new StudentListView();
//		new ConsoleView();
	}

}
