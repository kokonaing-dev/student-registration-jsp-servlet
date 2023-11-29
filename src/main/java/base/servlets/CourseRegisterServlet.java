package base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.daos.CourseDao;
import base.models.Course;
import base.models.User;


@WebServlet(value = "/CourseRegisterServlet")
public class CourseRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User admin = (User) session.getAttribute("admin");
		System.out.println("admin " + admin);
		User user = (User) session.getAttribute("user");
		System.out.println("user " + user);

		if(admin == null && user == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		}
		else {
			
			if(admin != null) {
				request.getRequestDispatcher("/courseRegister.jsp").forward(request, response);
			}
			
			else {
				request.setAttribute("msg", "Permission Denied");
				request.getRequestDispatcher("/menu.jsp").forward(request, response);
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String course_code = request.getParameter("course_code");
		String name = request.getParameter("name");
		
		
		Course course = new Course(course_code, name);
		
		CourseDao dao = new CourseDao();
		int result = dao.createCourse(course);
		
		if(result > 0) {
			request.setAttribute("msg", "Successfully added..");
			request.getRequestDispatcher("/menu.jsp").forward(request, response);

		}
		System.out.println(course_code + " " + name);
		
	}

}
