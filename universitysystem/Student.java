
public  class Student extends Person implements Enrollable{
	private String course;
	private double gwa;
	
	//with Overloading methods
	Student(String name, int age, int id, String course, double gwa){
		super(name, age, id);
		this.setCourse(course);
		this.setGwa(gwa);
	}
	//Getter
	public String getCourse() {
		return course;
	}
	
	public double getGwa() {
		return gwa;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public void setGwa(double gwa) {
		this.gwa = gwa;
	}
	
	public void enrollCourse(String courseName) {
		
	}

	@Override
	public void viewInfo() {
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Course: " + getCourse());
		System.out.printf("GWA: " + "%.2f%n", getGwa());
		System.out.println("ID: " + getId());
		enroll();
		System.out.println("-------------------");
	}
	
	@Override
	public void enroll() {
		System.out.println("This student is enrolled in " + getCourse());
	}
	
}
