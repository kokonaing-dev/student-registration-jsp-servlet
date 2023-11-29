package base.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.helpers.DbHelper;
import base.models.Enroll;

public class EnrollDao {
	
	
	
	public void enrollStudentInCourses(int stud_id, String[] courses) {
		
		if(courses != null) {
			Connection con = DbHelper.getInstance().getConnection();
			String query = "INSERT INTO enroll (course_id, student_id) VALUES (?, ?)";
			
			try {
				try (PreparedStatement stmt = con.prepareStatement(query)) {
					for (String courseID : courses) {
						int course_id = Integer.parseInt(courseID);
						
						stmt.setInt(1, course_id);
						stmt.setInt(2, stud_id);
						
						// Add to batch
						stmt.addBatch();
					}
					
					// Execute batch
					stmt.executeBatch();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
            System.out.println("No courses selected for enrollment.");
		}
	}
	
	
	public List<Enroll> getEnrollCourseByStudId(int  id) {
        ResultSet rs ;
        List<Enroll> enrolls = new ArrayList<>();
        Connection connection = DbHelper.getInstance().getConnection();
        String query = "SELECT * FROM enroll WHERE student.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
            	Enroll enroll = new Enroll();
            	enroll.setId(rs.getInt("id"));
            	enroll.setCourse_id(rs.getInt("course_id"));
            	enroll.setStud_id(rs.getInt("student_id"));
            	enrolls.add(enroll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrolls;
    }



}
