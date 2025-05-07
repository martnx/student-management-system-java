import java.util.ArrayList;

public class UniversitySystem {

	ArrayList<Person> people;
	Professor professor;
	HonorStudent honorStudent;
	Student student;
	
	UniversitySystem(){
		people = new ArrayList<>();
		//Students
		addStudent("Abra Kabadra", 20, giveId(), "BS-Medical Technology", 1.25);
		addStudent("Martin Legaspi", 23, giveId(), "BS-Business Administration", 1.50);
		addStudent("John Doe", 22, giveId(),"BS-Information Technology", 2.75);
		addStudent("Juan DelaCruz", 23, giveId(), "BS-Social Science", 1.69 );
		addStudent("Anna Mendoza", 21, giveId(), "BS-Computer Science", 1.75);
		addStudent("Bryan Reyes", 22, giveId(), "BS-Mechanical Engineering", 2.10);
		addStudent("Carla Santos", 20, giveId(), "BS-Psychology", 1.95);
		addStudent("Daniel Cruz", 23, giveId(), "BS-Nursing", 1.49);
		addStudent("Ella Ramirez", 19, giveId(), "BS-Information Technology", 2.25);
		addStudent("Francis Lopez", 24, giveId(), "BS-Civil Engineering", 2.50);
		addStudent("Grace Villanueva", 22, giveId(), "BS-Accountancy", 1.30);
		addStudent("Henry Bautista", 21, giveId(), "BS-Hotel and Restaurant Management", 2.80);
		addStudent("Isabelle Tan", 20, giveId(), "BS-Architecture", 1.85);
		addStudent("Jacob Perez", 23, giveId(), "BS-Business Administration", 2.00);
		addStudent("Kyla Lim", 21, giveId(), "BS-Political Science", 1.60);
		addStudent("Leo Gomez", 22, giveId(), "BS-Electrical Engineering", 2.35);
		addStudent("Mia Fernandez", 19, giveId(), "BS-Medical Technology", 1.20);
		addStudent("Nathaniel David", 23, giveId(), "BS-Pharmacy", 1.70);
		addStudent("Olivia Salazar", 20, giveId(), "BS-Entrepreneurship", 2.45);
		addStudent("Paolo Gutierrez", 22, giveId(), "BS-Industrial Engineering", 2.10);
		addStudent("Queenie Navarro", 21, giveId(), "BS-Physical Therapy", 1.40);
		addStudent("Rafael Torres", 24, giveId(), "BS-Aeronautical Engineering", 2.60);
		addStudent("Samantha Dizon", 20, giveId(), "BS-Environmental Science", 1.90);
		addStudent("Thomas Castillo", 23, giveId(), "BS-Chemistry", 2.15);
		
		//Professor
		addProfessor("Maria Santos", 45, giveId(), "Computer Science");
		addProfessor("Juan Dela Cruz", 50, giveId(), "Mathematics");
		addProfessor("Elena Robles", 39, giveId(), "Business Administration");
		addProfessor("Carlos Mendoza", 47, giveId(), "Psychology");
		addProfessor("Anna Villanueva", 42, giveId(), "Nursing");
		addProfessor("Roberto Ramos", 51, giveId(),  "History");
		addProfessor("Jennylyn Reyes", 35, giveId(), "Political Science");
		addProfessor("Michael Tan", 40, giveId(), "Mechanical Engineering");
		addProfessor("Sofia Lopez", 38, giveId(), "Architecture");
		addProfessor("Eduardo Garcia", 55, giveId(), "Economics");
		addProfessor("Katrina Diaz", 36, giveId(), "Education");
		addProfessor("Paulo Navarro", 48, giveId(), "Information Technology");
		addProfessor("Lourdes Jimenez", 43, giveId(), "Sociology");
		addProfessor("Victor Cruz", 52, giveId(), "Physics");
		addProfessor("Bea Lim", 37, giveId(), "Environmental Science");
		addProfessor("Nico Fernandez", 41, giveId(), "Fine Arts");
		addProfessor("Grace Bautista", 46, giveId(), "Civil Engineering");
		addProfessor("Oscar Herrera", 53, giveId(), "Biology");
		addProfessor("Isabel Aquino", 44, giveId(), "Philosophy");
		addProfessor("Julius Chavez", 49, giveId(), "Law");

	}
	
	public void addStudent(String name, int age, int id, String course, double gwa) {
		if((gwa >= 1.00 && gwa <= 1.25) || (gwa >= 1.26 && gwa <= 1.50) || (gwa >= 1.51 && gwa <= 1.75)) {
			honorStudent = new HonorStudent(name, age, giveId(), course, gwa);
			people.add(honorStudent);
		}
		else {
			student = new Student(name, age, giveId(), course, gwa);
			people.add(student);
		}
		System.out.println("Student: " + name + " added successfully!");
		
	}
	
	public void addProfessor(String name, int age, int id, String department) {
		professor = new Professor(name, age, id, department);
		people.add(professor);
		System.out.println("Professor: " + name + " added successfully!");
	}
	
	public void viewAllPeople() {
		for(Person s: people) {
			s.viewInfo();
			System.out.println("Total of " + people.size() +"person is registered.");
		}
	}
	
	public void viewAllStudents() {
		if(people.isEmpty()) {
			System.out.println("No students found.");
			return;
		}
		int count = 0;
		for(Person s: people) {
			if(s instanceof Student) {
				s.viewInfo();
				count++;
			}
		}
		System.out.println("Total of " + count +" students is enrolled.");
	}
	
	public void viewAllProfessors() {
		if(people.isEmpty()) {
			System.out.println("No Professor found.");
			return;
		}
		int count = 0;
		for(Person s: people) {
			if(s instanceof Professor) {
				s.viewInfo();
				count++;
			}
		}
		System.out.println("Total of " + count +" professor is registered.");
	}
	
	public void searchById(int searchId) {
		boolean studentFound = false;
		if(people.isEmpty()) {
			System.out.println("No students found.");
			return;
		}
	
		for(Person s: people) {
			if(s.getId() == searchId) {
				s.viewInfo();
				studentFound = true;
			}
		}
		if(!studentFound) {
			System.out.println("ID does not exist.");			
		}
		
	}
	
	public void removeById(int id) {
		boolean IDFound = false;
		if(people.isEmpty()) {
			System.out.println("ID does not exist.");
			return;
		}
		for(int i = 0; i < people.size(); i++) {
			Person per = people.get(i);
			if(per.getId() == id) {
				System.out.println("ID: " + per.getName() + " has been removed.");
				people.remove(i);
				IDFound = true;
			}
		}
		if(IDFound == false) {
			System.out.println("ID does not exist.");			
		}
	}
	
	public int giveId() {
		return people.size()+1;
	}
}
