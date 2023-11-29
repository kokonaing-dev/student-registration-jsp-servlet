package base.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.daos.UserDao;
import base.models.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao();
		User user =  dao.getUserByEmail(email);
		System.out.println("user " +user);
		
		if(user != null) {
			
			if(password.equals(user.getPassword())) {
				
				if(user.getRole().equals("Admin")) {
					System.out.println("admin");
					session.setAttribute("admin", user);
				}
				else {
					System.out.println("user");
					session.setAttribute("user", user);
				}
				
				request.setAttribute("msg", "login Success..");
				request.getRequestDispatcher("/menu.jsp").forward(request, response);
				System.out.println("Login Success...");
			}
			else {
				System.out.println("Password wrong..");
				request.setAttribute("msg", "Password Incorrect!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
			
		}
		else {
			System.out.println("New Customer...");
			request.setAttribute("msg", "You look like a new customer . Register first !");
			request.getRequestDispatcher("/userRegister.jsp").forward(request, response);

		}
		
	}

}
