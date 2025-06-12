package model;

public abstract class Person {
	protected String firstName;
	protected String lastName;
	protected int age;
	protected int id;
	
	Person(int id, String firstName, String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		//Age isn't available for now
		this.age = age;
		this.id = id;
	}
	//Setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	//Getter
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public int getId() {
		return id;
	}
	
	public abstract void viewInfo();
}
