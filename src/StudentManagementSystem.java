import java.util.ArrayList;

public class StudentManagementSystem {
	
	private ArrayList<Student> studentAL;
	
	StudentManagementSystem(){
		studentAL = new ArrayList<>();	
		studentAL.add(new Student("Abra Kabadra", 20, "BS-MEDTECH", giveID()));
		studentAL.add(new Student("Martin Legaspi", 23, "BSBA-HRM", giveID()));
		studentAL.add(new Student("John Doe", 22, "BSIT", giveID()));
		
	}
	public void addStudent(Student student) {	
		studentAL.add(student);
		System.out.println("Student: " + student.getName() + " added successfully!");
	}
		
	public void viewAllStudents() {
		if (studentAL.isEmpty()) {
			System.out.println("No students found.");
			return;
		}
		for(Student s: studentAL) {
	        System.out.println("Name: " + s.getName());
	        System.out.println("Age: " + s.getAge());
	        System.out.println("Course: " + s.getCourse());
		    System.out.println("ID: " + s.getId());
	        System.out.println("-------------------");
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
				System.out.println("We found ID: " + searchId);
		        System.out.println("Name: " + str.getName());
		        System.out.println("Age: " + str.getAge());
		        System.out.println("Course: " + str.getCourse());
			    System.out.println("ID: " + str.getId());
		        System.out.println("-------------------");
		        studentFound = true;

			}
			if(!studentFound) {
				System.out.println("Student ID didn't existed");			
			}
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
			System.out.println("Student ID didn't existed");			
		}
	}
	
	public int giveID() {
		return studentAL.size()+1;
	}
}
