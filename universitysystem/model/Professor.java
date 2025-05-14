package model;
import java.util.ArrayList;

public class Professor extends Person{
	
	String department;
	ArrayList<String> subjectsHandled;
	
	Professor(int id, String firstName, String lastName,  String department){
		super(id, firstName, lastName);
		this.setDepartment(department);
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public void viewInfo() {
		System.out.println("Name: " + getFullName());
		System.out.println("Age: " + getAge());
		System.out.println("Department: " + getDepartment());
		System.out.println("ID: " + getId());
		System.out.println("-------------------");
	}
	
}
