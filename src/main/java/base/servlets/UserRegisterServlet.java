package base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.daos.UserDao;
import base.models.User;


@WebServlet( value = "/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/userRegister.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		User user = new User(name,email,password,role);
		
		UserDao dao = new UserDao();
		int result = dao.createUser(user);
		 System.out.println(result);
		
		if (result <= 0) {
			request.getRequestDispatcher("/userRegister.jsp").forward(request, response);
		}
		
		response.sendRedirect(request.getContextPath() + "/UserViewServlet");

	}

}
