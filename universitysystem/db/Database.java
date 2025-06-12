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
    private Statement s = null;
    
    //class
    Person person;
    Student student;
    HonorStudent honorStudent;
	public Database(){
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/universityDB",
                "root",
                "022002" // change this to your MySQL password
            );
            System.out.println("✅Connected to Database (MySQL universityDB)");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
	}

	public void addStudents(String firstName, String lastName, String course, String units, String instructor, String gwa){
	   String sql = "INSERT INTO students(first_name, last_name, course, units, instructor, gwa) VALUES(" + "'" + firstName +  "'" +", " +  "'" + lastName +  "'" + ", " +  "'" + course +  "'" + ", " +  "'" + units +  "'" + ", " +  "'" + instructor + "'" + ", " + 
			   "'" + gwa +  "'" +");";
	   System.out.println(sql);
        try {
			System.out.println("✅Connected to Database (MySQL universityDataBase) = addStudent method");
    		s = conn.createStatement();
            s.executeUpdate(sql);
           
         
        }
        catch (SQLException e) {
        	System.out.println(e);
        }
	}
	
	public String deleteStudent(String idToPass) {
		String first_name = null;

		String sql = "select * from students";
		try {
			int id = Integer.parseInt(idToPass);
			String sqlDelete = "delete from students where person_id= " + id + "";		
			System.out.println("✅Connected to Database (MySQL univesityDB) = deleteStudent method");
			System.out.println(id);
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();
            
//            if(rs.next()) {
//            	String firstName = rs.getString("first_name");
//            	p = conn.prepareStatement(sqlDelete);
//            	p.setInt(1, id);
//            	p.executeUpdate();
//            	
//            }   
            
            
            while(rs.next()) {
            	int person_id = rs.getInt("person_id");
            	System.out.println(person_id);
            	if(person_id == id) {
                    p = conn.prepareStatement(sqlDelete);
                    p.execute();
                    System.out.println("This user is deleted - " + id);
                    return first_name = rs.getString("first_name");
            	}
            }
		}
		catch (SQLException e){
			System.out.println(e);
		}
		catch (NumberFormatException e) {
			System.out.println(e);
			return null;
		}
		return first_name;

	}
	
	public List<Student> loadStudents(){
		List<Student> students = new ArrayList<>();
        try {
          	 
            // SQL command data stored in String datatype
            String sql = "select * from studentdb;";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            // Condition check
            while (rs.next()) {
 
                int person_id = rs.getInt("person_id");	
                String first_name = rs.getString("firstName");
                String last_name = rs.getString("lastName");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                int units = rs.getInt("units");
                String instructor = rs.getString("instructor");
                double gwa = rs.getDouble("gwa");
                //Add the data in ArrayList
        		if((gwa >= 1.00 && gwa <= 1.25) || (gwa >= 1.26 && gwa <= 1.50) || (gwa >= 1.51 && gwa <= 1.75)) {
        			honorStudent = new HonorStudent(person_id, first_name, last_name, age, course, units, instructor, gwa);
        			students.add(honorStudent);
        		}
        		else {
        			student = new Student(person_id, first_name, last_name, age, course, units, instructor, gwa);
        			students.add(student);
        		}
        		
            }
        }      
        catch (SQLException e) {
            System.out.println(e);
            System.out.println("Make this");
        }
        return students;
	}

    public void updateStudent(){
    }


}
