package base.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.daos.StudentDao;
import base.models.Student;
import base.models.User;

@WebServlet("/StudentViewServlet")
public class StudentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentViewServlet() {
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
			
			StudentDao dao = new StudentDao();
			List<Student> students = dao.getAllStudent();
			
			System.out.println("Get all form db :"+students);
			
			request.setAttribute("students", students);
			request.getRequestDispatcher("/studentDisplay.jsp").forward(request, response);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
