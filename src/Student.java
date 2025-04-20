
public class Student {
	
	private String name;
	private int age;
	private String course;
	private int id;
	
	//with Overloading methods
	Student(String name, int age, String course, int id){
		this.setName(name);
		this.setAge(age);
		this.setCourse(course);
		this.setID(id);
	}
	Student(String name, int age, String course){
		this.setName(name);
		this.setAge(age);
		this.setCourse(course);
		
	}
	Student(String name, int age){
		this.setName(name);
		this.setAge(age);
		this.setCourse("undefined");
	}
	Student(String name){
		this.setName(name);
		this.setAge(0);
		this.setCourse("undefined");
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
	
	public void setID(int id) {
		this.id = id;
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
}
