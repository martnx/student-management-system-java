
public class HonorStudent extends Student implements Enrollable{
	
	HonorStudent(String name, int age, int id, String course, double gwa) {
		super(name, age, id, course, gwa);
		
	}

	public String printStudentTitle(double gwa) {
		String honor = "";
		if(gwa >= 1.00 && gwa <= 1.25) {
			honor = "Summa Cum Laude";
		}
		else if((gwa >= 1.26 && gwa <= 1.50)) {
			honor = "Magna Cum Laude";
		}
		else if((gwa >= 1.51 && gwa <= 1.75)) {
			honor = "Cum Laude";
		}
		return honor;
	}
	
	@Override
	public void viewInfo() {
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Course: " + getCourse());
	    System.out.println(printStudentTitle(getGwa()));
		System.out.printf("GWA: " + "%.2f%n", getGwa());
		System.out.println("ID: " + getId());
		System.out.println("-------------------");
	}
}	
