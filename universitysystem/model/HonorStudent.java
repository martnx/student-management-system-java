package model;
public class HonorStudent extends Student implements Enrollable{
	
	public HonorStudent(int id, String firstName, String lastName, String course, int units, String instructor, double gwa) {
		super(id, firstName, lastName, course, units, instructor, gwa);
		
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
		System.out.println("Name: " + getFullName());
		System.out.println("Age: " + getAge());
		System.out.println("Course: " + getCourse());
	    System.out.println(printStudentTitle(getGwa()));
		System.out.printf("GWA: " + "%.2f%n", getGwa());
		System.out.println("ID: " + getId());
		System.out.println("-------------------");
	}
}	
