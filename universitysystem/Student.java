
public  class Student extends Person implements Enrollable{
	private Course course;
	private double gwa;
	
	//with Overloading methods
	Student(String name, int age, int id, String courseName, int units, String instructor, double gwa){
		super(name, age, id);
		this.course = new Course(courseName, units, instructor);
		this.setGwa(gwa);
	}
	//Getter
	public String getCourse() {
		return course.getCourse();
	}
	
	public double getGwa() {
		return gwa;
	}
	
	public void setCourse(String course) {
		this.course.setCourse(course);
	}
	
	public void setGwa(double gwa) {
		this.gwa = gwa;
	}
	
	public void enrollCourse(Course c) {
		
	}

	@Override
	public void viewInfo() {
		System.out.println("Name: " + getName());
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
