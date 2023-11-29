package base.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.daos.StudentDao;
import base.daos.UserDao;

/**
 */
@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentDeleteServlet() {
        super(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDao dao = new StudentDao();
		int id = Integer.parseInt(request.getParameter("id"));
		int result = dao.deleteStudent(id);
		if(result > 0) {
			System.out.println("Delecting success..");
            request.setAttribute("msg", "successfuly deleted");
		}
		else {
			System.out.println("Delecting fail..");
            request.setAttribute("msg", "delecting error"); 
		}
		response.sendRedirect(request.getContextPath() + "/StudentViewServlet");

	}

}
