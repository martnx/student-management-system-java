package db;

import java.sql.*;
import java.util.*;

import model.HonorStudent;
import model.Person;
import model.Student;

public class Database {
	private Connection conn = null;
    private PreparedStatement p = null;
    private ResultSet rs = null;
    
    //class
    Person person;
    Student student;
    HonorStudent honorStudent;
	public Database(){
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/universitydb",
                "root",
                "022002" // change this to your MySQL password
            );
            System.out.println("✅Connected to Database (MySQL univesityDB)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void addStudents() {
		
	}
	
	public List<Student> loadStudents(){
		List<Student> students = new ArrayList<>();
        try {
          	 
            // SQL command data stored in String datatype
            String sql = "select * from students";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();
 
            // Printing ID, name, email of customers
            // of the SQL command above
            System.out.println("first_name/last_name/person_id");
 
            // Condition check
            while (rs.next()) {
 
                int person_id = rs.getInt("person_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String course = rs.getString("course");
                int units = rs.getInt("units");
                String instructor = rs.getString("instructor");
                double gwa = rs.getDouble("gwa");
                //Add the data in ArrayList
        		if((gwa >= 1.00 && gwa <= 1.25) || (gwa >= 1.26 && gwa <= 1.50) || (gwa >= 1.51 && gwa <= 1.75)) {
        			honorStudent = new HonorStudent(person_id, first_name, last_name, course, units, instructor, gwa);
        			students.add(honorStudent);
        		}
        		else {
        			student = new Student(person_id, first_name, last_name, course, units, instructor, gwa);
        			students.add(student);
        		}
        		
            }
        }      
        catch (SQLException e) {
            System.out.println(e);
        }
        return students;
	}
}
