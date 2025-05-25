package model;

public class Course{
	private String course;
	private int units;
	private String instructor;
	
	Course(String course, int units, String instructor){
		this.setCourse(course);
		this.setUnits(units);
		this.setInstructor(instructor);
	}
	
	//Getter
	public String getCourse() {
		return course;
	}
	
	public int getUnits() {
		return units;
	}
	
	public String getInstructor() {
		return instructor;
	}
	
	//Setter
	public void setCourse(String course) {
		this.course = course;
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
