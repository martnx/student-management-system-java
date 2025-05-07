
public abstract class Person {
	protected String name;
	protected int age;
	protected int id;
	
	Person(String name, int age, int id){
		this.name = name;
		this.age = age;
		this.id = id;
	}
	//Setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	//Getter
	public String getName() {
		return name;
	}
		
	public int getAge() {
		return age;
	}
	
	public int getId() {
		return id;
	}
	
	public abstract void viewInfo();
}
