package base.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.daos.UserDao;
import base.models.User;


@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     */
    public UserSearchServlet() {
        super();
    }

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		
		String name = request.getParameter("name");

		System.out.println("name "+ name);
		
		if(name!=null) {
			
			List<User> users = dao.searchUserByName(name);
			System.out.println(users);
			request.setAttribute("users", users);
			System.out.println("user by name :" + users);
			
			request.getRequestDispatcher("/userDisplay.jsp").forward(request, response);
		}
		
		else {
			request.getRequestDispatcher("/userDisplay.jsp").forward(request, response);

		}



	}

}
