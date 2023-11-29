package base.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.helpers.DbHelper;
import base.models.User;

public class UserDao {
	
	
	public int createUser(User user) {
        int status = 0 ;
        Connection connection = DbHelper.getInstance().getConnection();
        String query="INSERT INTO user (name , email , password  , role) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getRole());
            status =  ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
	
	
	
	public int userDelete(int user_id) {
        int status = 0 ;
        Connection connection = DbHelper.getInstance().getConnection();
        String query="DELETE FROM user WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,user_id);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
	
	
	public User getUserById(int user_id) {
        ResultSet resultSet ;
        User user = new User();
        Connection connection = DbHelper.getInstance().getConnection();
        String query="SELECT * FROM user WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,user_id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
	
	
	 public List<User> getAllUsers() {
	        ResultSet resultSet ;
	        List<User> users = new ArrayList<>();
	        Connection connection = DbHelper.getInstance().getConnection();
	        String query="SELECT * FROM user";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(query);
	            resultSet = stmt.executeQuery();
	            while (resultSet.next()){
	                User user = new User();
	                user.setId(resultSet.getInt("id"));
	                user.setName(resultSet.getString("name"));
	                user.setEmail(resultSet.getString("email"));
	                user.setPassword(resultSet.getString("password"));
	                user.setRole(resultSet.getString("role"));
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
	 
	 
	 public int editUser(User user) {
	        int status = 0;
	        Connection connection = DbHelper.getInstance().getConnection();
	        String query="UPDATE user SET name=? , email=? , password=? , role=? WHERE id=?";
	        try {
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setString(1,user.getName());
	            ps.setString(2,user.getEmail());
	            ps.setString(3,user.getPassword());
	            ps.setString(4,user.getRole());
	            ps.setInt(5,user.getId());
	            status = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    }

	 
	 
	 public User getUserByEmail(String email) {
		 User user = null;
		 ResultSet rs ;
		 Connection connection = DbHelper.getInstance().getConnection();
	        String query="SELECT * FROM user WHERE email=?";
	        try {
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setString(1,email);
	            rs = ps.executeQuery();
	           while(rs.next()) {
	        	   user = new User();
	        	   user.setId(rs.getInt("id"));
	        	   user.setName(rs.getString("name"));
	        	   user.setEmail(rs.getString("email"));
	        	   user.setPassword(rs.getString("password"));
	        	   user.setRole(rs.getString("role"));
	           }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }  
		 return user ;
	 }
	 
	 public List<User> searchUserByName(String search) {
	        ResultSet rs ;
	        List<User> users = new ArrayList<>();
	        Connection connection = DbHelper.getInstance().getConnection();
	        String query = "SELECT * FROM user where name LIKE ?";

	        try {
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setString(1,"%"+search+"%");
	            rs = ps.executeQuery();
	            while (rs.next()){
	                User user = new User();
	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                user.setRole(rs.getString("role"));
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
	 
	 public List<User> searchUserByID(int  id) {
	        ResultSet rs ;
	        List<User> users = new ArrayList<>();
	        Connection connection = DbHelper.getInstance().getConnection();
	        String query = "SELECT * FROM user where id = ?";

	        try {
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setInt(1, id);
	            rs = ps.executeQuery();
	            while (rs.next()){
	                User user = new User();
	                user.setId(rs.getInt("id"));
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                user.setRole(rs.getString("role"));
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
}
