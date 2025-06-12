package model;

public  class Student extends Person implements Enrollable{
	private Course course;
	private double gwa;
	
	//with Overloading methods
	public Student(int id, String firstName, String lastName, int age, String course, int units, String instructor, double gwa){
		super(id, firstName, lastName, age);
		this.course = new Course(course, units, instructor);
		this.setGwa(gwa);
	}
	//Getter
	public String getCourse() {
		return course.getCourse();
	}
	
	public int getUnits() {
		return course.getUnits();
	}
	public String getInstructor() {
		return course.getInstructor();
	}
	
	public double getGwa() {
		return gwa;
	}
	
	//Setter
	public void setCourse(String courseName) {
		course.setCourse(courseName);
	}
	
	public void setUnits(int units) {
		course.setUnits(units);
	}
	public void setInstructor(String instructor) {
		course.setInstructor(instructor);
	}
	
	public void setGwa(double gwa) {
		this.gwa = gwa;
	}
	
	public void enrollCourse(Course c) {
		
	}

	@Override
	public void viewInfo() {
		System.out.println("Name: " + getFullName());
		System.out.println("Age: " + getAge());
		System.out.println("Course: " + course.getCourse() + " Units: " + course.getUnits() + " Instructor: " + course.getInstructor());
		System.out.printf("GWA: " + "%.2f%n", getGwa());
		System.out.println("ID: " + getId());
		enroll();
		System.out.println("-------------------");
	}
	
	@Override
	public void enroll() {
		System.out.println("This student is enrolled in " + course.getCourse());
	}

	
}
