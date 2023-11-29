package base.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import base.helpers.DbHelper;
import base.models.Course;
import base.models.Student;

public class StudentDao {
	
	//create student and generate id back
	public int createStudent(Student student) {
		int generatedStudId = -1 ;
        Connection con = DbHelper.getInstance().getConnection();
        String query = "INSERT INTO student (name,dob,gender,phone,education,photo,created_up) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
            ps.setString(1, student.getName());
            ps.setString(2 , student.getDob());
            ps.setString(3 , student.getGender());
            ps.setString(4 , student.getPhone());
            ps.setString(5 , student.getEducation());
            ps.setString(6,student.getPhoto());
            ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
       
            int result = ps.executeUpdate();

            // for generating orderId because we need orderId
            if (result > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                	generatedStudId = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedStudId;
    }
	
	
	public int deleteStudent(int id) {
        int status = 0;
        Connection connection = DbHelper.getInstance().getConnection();
        String query = "DELETE FROM student WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,id);
            status = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;    
     }
	
	public int editStudent(Student student) {
        int status = 0;
        Connection connection = DbHelper.getInstance().getConnection();
        String query = "UPDATE student SET name=?,dob=?,gender=?,phone=?,education=?,photo=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,student.getName());
            stmt.setString(2,student.getDob());
            stmt.setString(3,student.getGender());
            stmt.setString(4,student.getPhone());
            stmt.setString(5,student.getEducation());
            stmt.setString(6, student.getPhoto());
            stmt.setInt(7,student.getId());
            status = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
	
	public Student getStudentById(int id) {
        ResultSet resultSet;
        Student student = new Student();
        Connection connection = DbHelper.getInstance().getConnection();
        String query = "SELECT * FROM student WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
            	student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDob(resultSet.getString("dob"));
                student.setGender(resultSet.getString("gender"));
                student.setPhone(resultSet.getString("phone"));
                student.setEducation(resultSet.getString("education"));
                student.setPhoto(resultSet.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
	
	public List<Student> getAllStudent() {
        ResultSet resultSet ;
        List<Student> students = new ArrayList<>();
        Connection connection = DbHelper.getInstance().getConnection();
        String query = "SELECT * FROM student";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDob(resultSet.getString("dob"));
                student.setGender(resultSet.getString("gender"));
                student.setPhone(resultSet.getString("phone"));
                student.setEducation(resultSet.getString("education"));
                student.setPhoto(resultSet.getString("photo"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
	
	
}
