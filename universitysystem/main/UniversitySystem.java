package main;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import model.Course;
import model.HonorStudent;
import model.Person;
import model.Professor;
import model.Student;

public class UniversitySystem {

	//Professor, Student, HonorStudent is holding this arrayList
	List<Person> person;
	List<Student> students;

	Professor professor;
	HonorStudent honorStudent;
	Student s;
	Course course;
	
	Database database;
	
	public UniversitySystem(){
		//Loading this object from database
		person = new ArrayList<>();
		database = new Database();
		students = database.loadStudents();



	}
	
	public void addStudent(String name, int age, int id, String courseName, int units, String instructor, double gwa) {
//		if((gwa >= 1.00 && gwa <= 1.25) || (gwa >= 1.26 && gwa <= 1.50) || (gwa >= 1.51 && gwa <= 1.75)) {
//			honorStudent = new HonorStudent(name, age, giveId(), courseName, units, instructor, gwa);
//			people.add(honorStudent);
//		}
//		else {
//			student = new Student(name, age, giveId(), courseName, units, instructor, gwa);
//			people.add(student);
//		}
//		System.out.println("Student: " + name + " added successfully!" +"Student Array size = ");
	}
	
	public void addProfessor(String name, int age, int id, String department) {
//		professor = new Professor(name, age, id, department);
//		person.add(professor);
//		System.out.println("Professor: " + name + " added successfully!");
	}
	
	public void viewAllPeople() {
		
		for(Person s: person) {
			s.viewInfo();
			System.out.println("Total of " + person.size() +"person is registered.");
		}
	}
	
	public void viewAllStudents() {
		if(students.isEmpty()) {
			System.out.println("No students found.");
			return;
		}
		int count = 0;
		for(Student s: students) {
			s.viewInfo();
		}		
		System.out.println("Total of " + count +" students is enrolled.");
		
	}
	
	public void viewAllProfessors() {
		if(person.isEmpty()) {
			System.out.println("No Professor found.");
			return;
		}
		int count = 0;
		for(Person s: person) {
			if(s instanceof Professor) {
				s.viewInfo();
				count++;
			}
		}
		System.out.println("Total of " + count +" professor is registered.");
	}
	
	public void searchById(int searchId) {
		boolean studentFound = false;
		if(person.isEmpty()) {
			System.out.println("No students found.");
			return;
		}
	
		for(Person s: person) {
			if(s.getId() == searchId) {
				s.viewInfo();
				studentFound = true;
			}
		}
		if(!studentFound) {
			System.out.println("ID does not exist.");			
		}
		
	}
	
	public void removeById(int id) {
		boolean IDFound = false;
//		if(person.isEmpty()) {
//			System.out.println("ID does not exist.");
//			return;
//		}
//		for(int i = 0; i < person.size(); i++) {
//			Person per = person.get(i);
//			if(per.getId() == id) {
//				System.out.println("ID: " + per.getFullName() + " has been removed.");
//				person.remove(i);
//				IDFound = true;
//			}
//		}
		if(IDFound == false) {
			System.out.println("ID does not exist.");			
		}
	}
	
	public List<Person> getList(){
		return person;
	}
	
}
