package main;
import java.util.ArrayList;

import model.HonorStudent;
import model.Student;

public class StudentManagementSystem {
	
	private ArrayList<Student> studentAL;
	
	public StudentManagementSystem(){
		studentAL = new ArrayList<>();	
//		addStudent("Abra Kabadra", 20, "BS-Medical Technology", 1.25 , giveID());
//		addStudent("Martin Legaspi", 23, "BS-Business Administration", 1.50, giveID());
//		addStudent("John Doe", 22, "BS-Information Technology", 2.75, giveID());
//		addStudent("Juan DelaCruz", 23, "BS-Social Science", 1.69 , giveID());
//		addStudent("Anna Mendoza", 21, "BS-Computer Science", 1.75, giveID());
//		addStudent("Bryan Reyes", 22, "BS-Mechanical Engineering", 2.10, giveID());
//		addStudent("Carla Santos", 20, "BS-Psychology", 1.95, giveID());
//		addStudent("Daniel Cruz", 23, "BS-Nursing", 1.49, giveID());
//		addStudent("Ella Ramirez", 19, "BS-Information Technology", 2.25, giveID());
//		addStudent("Francis Lopez", 24, "BS-Civil Engineering", 2.50, giveID());
//		addStudent("Grace Villanueva", 22, "BS-Accountancy", 1.30, giveID());
//		addStudent("Henry Bautista", 21, "BS-Hotel and Restaurant Management", 2.80, giveID());
//		addStudent("Isabelle Tan", 20, "BS-Architecture", 1.85, giveID());
//		addStudent("Jacob Perez", 23, "BS-Business Administration", 2.00, giveID());
//		addStudent("Kyla Lim", 21, "BS-Political Science", 1.60, giveID());
//		addStudent("Leo Gomez", 22, "BS-Electrical Engineering", 2.35, giveID());
//		addStudent("Mia Fernandez", 19, "BS-Medical Technology", 1.20, giveID());
//		addStudent("Nathaniel David", 23, "BS-Pharmacy", 1.70, giveID());
//		addStudent("Olivia Salazar", 20, "BS-Entrepreneurship", 2.45, giveID());
//		addStudent("Paolo Gutierrez", 22, "BS-Industrial Engineering", 2.10, giveID());
//		addStudent("Queenie Navarro", 21, "BS-Physical Therapy", 1.40, giveID());
//		addStudent("Rafael Torres", 24, "BS-Aeronautical Engineering", 2.60, giveID());
//		addStudent("Samantha Dizon", 20, "BS-Environmental Science", 1.90, giveID());
//		addStudent("Thomas Castillo", 23, "BS-Chemistry", 2.15, giveID());
		
		//Add feature that automatically can sort the honor student
	}

	public int giveID() {
		return studentAL.size()+1;
	}
	
	public boolean checkIfHonorStudent(double gwa) {
		if((gwa >= 1.00 && gwa <= 1.25) || (gwa >= 1.26 && gwa <= 1.50) || (gwa >= 1.51 && gwa <= 1.75)) {
		return true;
		}
		return false;
	}
	
	public void addStudent(String name, int age, String course, double gwa, int id) {	
		
	}
	
	public void viewAllStudents() {
		if (studentAL.isEmpty()) {
			System.out.println("No students found.");
			return;
		}
	
		for(Student s: studentAL) {
			s.viewInfo();
		}
	}
	
	public void viewAllHonorStudents() {
		if(studentAL.isEmpty()) {
			System.out.println("No honor students found.");
			return;
		}
		for(Student s: studentAL) {
			if(s instanceof HonorStudent honor) {
				honor.viewInfo();
			}
		}
	}
	
	public void searchById(int searchId) {
		boolean studentFound = false;
		if(studentAL.isEmpty()) {
			System.out.println("No students found.");
			return;
		}
		for(int i = 0; i < studentAL.size(); i++) {
			Student str  = studentAL.get(i);
			if(str.getId() == searchId) {
				str.viewInfo();
		        studentFound = true;
			}
		}
		if(!studentFound) {
			System.out.println("Student ID does not exist.");			
		}
	}
	
	public void removeStudent(int id) {
		boolean studentFound = false;
		if(studentAL.isEmpty()) {
			System.out.println("No students found.");
			return;
		}
		for(int i = 0; i < studentAL.size(); i++) {
			Student str = studentAL.get(i);
			if(str.getId() == id) {
				System.out.println("Student: " + str.getName() + " has been removed.");
				studentAL.remove(i);
				studentFound = true;
			}
		}
		if(studentFound == false) {
			System.out.println("Student ID does not exist.");			
		}
	}
}
