package base.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.daos.CourseDao;
import base.daos.UserDao;
import base.models.Course;
import base.models.User;


@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserUpdateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		CourseDao dao = new CourseDao();
//		List<Course> courses = dao.getAllCourse();
//		request.setAttribute("courses" , courses);
		
		int id = Integer.parseInt(request.getParameter("id"));
		UserDao udao = new UserDao();
		User user = udao.getUserById(id);
		request.setAttribute("user",user);
		request.getRequestDispatcher("/userUpdate.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		int id = Integer.parseInt(request.getParameter("id"));

		User user = new User(id,name,email,password,role);
		UserDao dao = new UserDao();
		int result = dao.editUser(user);
		
		if(result > 0) {
			System.out.println("Successfully Update");
			response.sendRedirect(request.getContextPath() + "/UserViewServlet");
		}
		else {
			System.out.println("Fail to update");
			request.getRequestDispatcher("/userUpdate.jsp").forward(request, response);
		}

		
		
		System.out.println(user);
		
	}

}
