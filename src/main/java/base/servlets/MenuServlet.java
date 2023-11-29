package base.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.models.User;


@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MenuServlet() {
        super();
    }

	
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
			
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
			
		}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
