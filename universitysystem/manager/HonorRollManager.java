package manager;

import main.*;
import java.util.List;

import main.UniversitySystem;
import model.Person;
import model.Student;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class HonorRollManager{
	UniversitySystem uSystem;
	List<Person> allPerson;
	List<Student> studentArray;

	
	HonorRollManager() {
		uSystem = new UniversitySystem();
		studentArray = new ArrayList<>();
		allPerson = uSystem.getList();
		for(Person s: allPerson) {
			if(s instanceof Student) {
				studentArray.add((Student) s);
			}
		}
		
	}
	
	private List<Student> getHonorStudents(){
		List<Student> honorList = new ArrayList<>();
		for(Student student : studentArray) {
			if(student.getGwa() <= 1.75) {
				honorList.add(student);
			}
		}
		return honorList;
	}
	
	private void sortHonorStudentsByGwa(List<Student> honorStudents) {
	    honorStudents.sort(Comparator.comparingDouble(Student::getGwa));
	}
	
	private String getHonorTitle(double gwa) {
	    if (gwa <= 1.25) {
	        return "Summa Cum Laude";
	    } else if (gwa <= 1.50) {
	        return "Magna Cum Laude";
	    } else {
	        return "Cum Laude";
	    }
	}

	
	public void displayHonorRoll() {
		List<Student> honorStudents = getHonorStudents();
		sortHonorStudentsByGwa(honorStudents);
		
		for(Person s: honorStudents){
			System.out.println(s.getFullName());
		}
		
		System.out.println("Honor Roll Students - Method");
	    DecimalFormat df = new DecimalFormat("0.00");

		for(Student student: honorStudents) {
			System.out.println(student.getFullName() + " | GWA: " + df.format(student.getGwa()) + " | " + getHonorTitle(student.getGwa()));
		}
		
	}

	
}
