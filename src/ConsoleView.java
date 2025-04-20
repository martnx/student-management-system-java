import java.util.Scanner;

public class ConsoleView {
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
    
    	student = new Student(cap, studentAge, studentCourse, sms.giveID());
    	sms.addStudent(student);
    } 

    void viewAllStudents() {
        sms.viewAllStudents();
    }
    
    void searchById() {
        System.out.print("Enter the Student ID: ");
        int searchId = scan.nextInt();
        sms.searchById(searchId);
    }

    void removeStudent() {
        System.out.print("Enter Student ID to Remove:  ");
        int id = scan.nextInt();
        sms.removeStudent(id);
    }
    
	public ConsoleView(){
		boolean exit = false;
		int choice;
		while(!exit) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("[1] Add Student");
            System.out.println("[2] View All Students");
            System.out.println("[3] Search by ID");
            System.out.println("[4] Remove Student");
            System.out.println("[5] Exit");
            System.out.print("Enter your choice: ");
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                scan.nextLine(); // <-- This clears the leftover newline
            } else {
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                scan.nextLine(); // Clear the invalid input
                continue;
            }
			switch(choice) {
				case 1:
					addStudent();
 					break;
				case 2:
					viewAllStudents();
					break;
				case 3:
					searchById();
					break;
				case 4:
					removeStudent();
					break;
				case 5: 
					exit = true;
					break;
				default: System.out.println("ERROR!: Enter valid input!");
			}
		}
		scan.close();
	}
}
