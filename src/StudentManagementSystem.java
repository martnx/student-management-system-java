import java.util.ArrayList;

public class StudentManagementSystem {
	
	private ArrayList<Student> studentAL;
	private HonorStudent hs;
	
	StudentManagementSystem(){
		studentAL = new ArrayList<>();	
		studentAL.add(new Student("Abra Kabadra", 20, "BS-Medical Technology", 1.25 , giveID()));
		studentAL.add(new Student("Martin Legaspi", 23, "BS-Business Administration", 1.50, giveID()));
		studentAL.add(new Student("John Doe", 22, "BS-Information Technology", 2.75, giveID()));
		
		Student s = new Student("Not Honor", 20, "BS-Biology", 2.00, giveID());
 		
		//With honor students
		hs = new HonorStudent("Charie Zard", 23, "BS-Nursing", 1.50, giveID());
		studentAL.add(hs);
		hs = new HonorStudent("Juan DelaCruz", 23, "BS-Social Science", 1.69 , giveID());
		studentAL.add(hs);
		
		
	}
	
	public int giveID() {
		return studentAL.size()+1;
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
			if(s instanceof HonorStudent) {
				System.out.println("Name: " + s.getName());
				System.out.println("Age: " + s.getAge());
				System.out.println("Course: " + s.getCourse());
				System.out.println("ID: " + s.getId());
				System.out.printf("GWA: " + "%.2f%n", s.getGwa());
				System.out.println(printStudentTitle(s.getGwa()));
				System.out.println("-------------------");
			}
			else {
				System.out.println("Name: " + s.getName());
				System.out.println("Age: " + s.getAge());
				System.out.println("Course: " + s.getCourse());
				System.out.println("ID: " + s.getId());
				System.out.printf("GWA: " + "%.2f%n", s.getGwa());
				System.out.println("-------------------");
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
				System.out.println("We found ID: " + searchId);
		        System.out.println("Name: " + str.getName());
		        System.out.println("Age: " + str.getAge());
		        System.out.println("Course: " + str.getCourse());
			    System.out.println("ID: " + str.getId());
			    System.out.println(printStudentTitle(str.getGwa()));
			    System.out.printf("GWA: " + "%.2f%n", str.getGwa());
		        System.out.println("-------------------");
		        studentFound = true;
			}
		}
		if(!studentFound) {
			System.out.println("Student ID didn't existed");			
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
	
	public String printStudentTitle(double gwa) {
		
		String honor = "";
		if(gwa >= 1.00 && gwa <= 1.25) {
			honor = "Summa Cum Laude";
		}
		else if((gwa >= 1.26 && gwa <= 1.50)) {
			honor = "Magna Cum Laude";
		}
		else if((gwa >= 1.51 && gwa <= 1.75)) {
			honor = "Cum Laude";
		}
		return honor;
		
	}
}
