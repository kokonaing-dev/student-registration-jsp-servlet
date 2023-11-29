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

/**
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User admin = (User) session.getAttribute("admin");
		System.out.println("admin " + admin);
		User user = (User) session.getAttribute("user");
		System.out.println("user " + user);

		if (admin == null && user == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		}
		else {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDao dao = new UserDao();
		int id = Integer.parseInt(request.getParameter("id"));
		int result = dao.userDelete(id);
		if (result > 0) {
			System.out.println("Delecting success..");
			request.setAttribute("msg", "successfuly deleted");
		} else {
			System.out.println("Delecting fail..");
			request.setAttribute("msg", "delecting error");
		}
		response.sendRedirect(request.getContextPath() + "/UserViewServlet");

	}

}
