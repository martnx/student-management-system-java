package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import manager.HonorRollManager;
import model.Student;

public class ConsoleView {
	
	UniversitySystem system = new UniversitySystem();

	
	
	StudentManagementSystem sms = new StudentManagementSystem();
	Student student;
	Scanner scan = new Scanner(System.in);
	
	public static String capitalize(String str) {
		if(str.isEmpty()) {
			System.out.println("\nYou can't input blank name!");
			return null;
		}
		String[] stringArray = str.split("\\s+");
		String first;
		String rest;
		String result;
		String[] newArray = new String[stringArray.length];
		
		for(int i = 0; i < stringArray.length; i++) {
			first = stringArray[i].substring(0, 1).toUpperCase();
			rest = stringArray[i].substring(1).toLowerCase();			
			result = first + rest;
			newArray[i] = result;
		} 
		String joinedArray = String.join(" ", newArray);
		return joinedArray;
	}
	
    void addStudent() {
    	String studentName;
    	System.out.print("Enter Student Name: ");
    	studentName = scan.nextLine();
    	String cap;
    	if(!studentName.isEmpty()) {
        	cap = capitalize(studentName);
    	}
    	else {
    		System.out.println("\nYou can't input blank name!");
    		return;
    	}

    	System.out.print("Enter Student Age: ");
    	int studentAge = scan.nextInt();
    	scan.nextLine();
    	
    	System.out.print("Enter Student Course: ");
    	String studentCourse = scan.nextLine();
    	
    	System.out.print("Enter Student Units: ");
    	int studentUnits = scan.nextInt();
    	
      	scan.nextLine();
    	System.out.print("Enter Student Instructor: ");
    	String studentInstructor = scan.nextLine();
    	
    	System.out.print("Enter Student GWA: ");
    	double gwa = scan.nextDouble();
    	
//    	system.addStudent();
    } 

    void addProfessor() {
    	String profName;
    	System.out.print("Enter Professor Name: ");
    	profName = scan.nextLine();
    	String cap;
    	if(!profName.isEmpty()) {
        	cap = capitalize(profName);
    	}
    	else {
    		System.out.println("\nYou can't input blank name!");
    		return;
    	}

    	System.out.print("Enter Professor Age: ");
    	int profAge = scan.nextInt();
    	scan.nextLine();
    	
    	System.out.print("Enter Professor Department: ");
    	String profDepartment = scan.nextLine();
    	
    	system.addProfessor(cap, profAge, system.giveId(), profDepartment);
    	
    }
    
    void viewAllPeople() {
    	system.viewAllPeople();
    }
    
    void viewAllStudents() {
        system.viewAllStudents();
    }
    
    void viewAllProfessors() {
    	system.viewAllProfessors();
    }
    
    void viewAllHonorStudents() {
    	sms.viewAllHonorStudents();
    }
    void searchById() {
        System.out.print("Enter the Student ID: ");
        int searchId = scan.nextInt();
        sms.searchById(searchId);
    }

    void removeById() {
        System.out.print("Enter ID to Remove:  ");
        int id = scan.nextInt();
        system.removeById(id);
    }

    void honorRollManager() {
    	HonorRollManager hrm = new HonorRollManager();
    	hrm.displayHonorRoll();
    }
    
	public ConsoleView(){
		boolean exit = false;
		int choice;
		while(!exit) {
            System.out.println("\n===== University Management System =====");
            System.out.println("[1] Add Student");
            System.out.println("[2] Add Professor");
            System.out.println("[3] View All People");
            System.out.println("[4] View Students");
            System.out.println("[5] View Professors");
            System.out.println("[6] Search by ID");
            System.out.println("[7] View Roll Honor");
            System.out.println("[8] Remove Person");
            System.out.println("[9] Exit");
            System.out.print("Enter your choice: ");
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                scan.nextLine(); // <-- This clears the leftover newline
            } else {
                System.out.println("Invalid input. Please enter a number from 1 to 6.");
                scan.nextLine(); // Clear the invalid input
                continue;
            }
			switch(choice) {
				case 1:
					addStudent();
 					break;
				case 2:
					addProfessor();
					break;
				case 3:
					viewAllPeople();
					break;
				case 4:
					viewAllStudents();
					break;
				case 5:
					viewAllProfessors();
					break;
				case 6:
					searchById();
					break;
				case 7:
					honorRollManager();					
					break;
				case 8: 
					removeById();
					break;
				case 9:
					exit = true;
					break;
				default: System.out.println("ERROR!: Enter valid input!");
			}
		}
		scan.close();
	}
}
 