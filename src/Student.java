
public class Student extends Person{
	private String course;
	private double gwa;
	private int id;
	
	//with Overloading methods
	Student(String name, int age, String course, double gwa , int id){
		super(name, age);
		this.setCourse(course);
		this.setGwa(gwa);
		this.setID(id);
	}
	Student(String name, int age, String course, double gwa){
		super(name, age);
		this.setCourse(course);
		this.setGwa(gwa);
		this.setID(id);
	}
	
	//Getter
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getCourse() {
		return course;
	}
	
	public int getId() {
		return id;
	}
	public double getGwa() {
		return gwa;
	}
	
	//Setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public void setGwa(double gwa) {
		this.gwa = gwa;
	}
	
	public void setID(int id) {
		this.id = id;
	}
}
