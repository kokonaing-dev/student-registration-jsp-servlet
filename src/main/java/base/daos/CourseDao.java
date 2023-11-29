package base.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.helpers.DbHelper;
import base.models.Course;
import base.models.User;

public class CourseDao {
	
	
	//creating course 
	 public int createCourse(Course course) {
	        int status = 0;
	        Connection connection = DbHelper.getInstance().getConnection();
	        String query = "INSERT INTO course (course_code,name) VALUES (?,?)";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(query);
	            stmt.setString(1,course.getCourse_code());
	            stmt.setString(2,course.getName());
	            status=stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    }
	 
	 
	 //list of course - usually use in display
	 public List<Course> getAllCourse() {
	        ResultSet resultSet;
	        List<Course> courses = new ArrayList<>();
	        Connection connection = DbHelper.getInstance().getConnection();
	        String query = "SELECT * FROM course";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(query);
	            resultSet=stmt.executeQuery();
	            while (resultSet.next()){
	                Course course = new Course();
	                course.setId(resultSet.getInt("id"));
	                course.setCourse_code(resultSet.getString("course_code"));
	                course.setName(resultSet.getString("name"));
	                courses.add(course);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return courses;
	    }
	 
	 public Course getCourseByID(int id) {
	        ResultSet resultSet ;
	        Course course = new Course();
	        Connection connection = DbHelper.getInstance().getConnection();
	        String query="SELECT * FROM course WHERE id=?";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(query);
	            stmt.setInt(1,id);
	            resultSet = stmt.executeQuery();
	            while (resultSet.next()){
	            	course.setId(resultSet.getInt("id"));
	            	course.setCourse_code(resultSet.getString("course_code"));
	            	course.setName(resultSet.getString("name"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return course;
	    }

	 public List<Course> getCorsesByStudId(int  id) {
	        ResultSet rs ;
	        List<Course> courses = new ArrayList<>();
	        Connection connection = DbHelper.getInstance().getConnection();
	        String query = "SELECT course.name FROM course INNER JOIN enroll ON course.id = enroll.course_id WHERE enroll.student_id = ?";
	        try {
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setInt(1, id);
	            rs = ps.executeQuery();
	            while (rs.next()){
	            	Course course = new Course();
	            	course.setId(rs.getInt("id"));
	            	course.setCourse_code(rs.getString("course_code"));
	            	course.setName(rs.getString("name"));
	                courses.add(course);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return courses;
	    }

}
