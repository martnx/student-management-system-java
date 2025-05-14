package model;

public class Course{
	private String courseName;
	private int units;
	private String instructor;
	
	Course(String courseName, int units, String instructor){
		this.setCourse(courseName);
		this.setUnits(units);
		this.setInstructor(instructor);
	}
	
	//Getter
	public String getCourse() {
		return courseName;
	}
	
	public int getUnits() {
		return units;
	}
	
	public String getInstructor() {
		return instructor;
	}
	
	//Setter
	public void setCourse(String courseName) {
		this.courseName = courseName;
	}
	
	public void setUnits(int unit) {
		this.units = unit;
	}
	
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public void viewInfo() {
		
	}
}
