package base.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.daos.CourseDao;
import base.daos.StudentDao;
import base.models.Course;
import base.models.Student;


@WebServlet("/StudentDetailServlet")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentDetailServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CourseDao cdao = new CourseDao();
		List<Course> courses = cdao.getAllCourse();
		request.setAttribute("courses", courses);
		
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDao dao = new StudentDao();
		Student stud = dao.getStudentById(id);
		request.setAttribute("stud", stud);
		request.getRequestDispatcher("/studentDetails.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String education = request.getParameter("education");
		String [] courses = request.getParameterValues("course");
		String photo = request.getParameter("file");
		
		
		
		Student stud = new Student(id,name,dob,gender,phone,education,photo);
		
		System.out.println("Updating... "+ stud);
		StudentDao dao = new StudentDao();
		int result = dao.editStudent(stud);
		if(result > 0) {
			request.setAttribute("msg", "Update successfully..");
		}
		else {
			request.setAttribute("msg", "Error...");
		}
		response.sendRedirect(request.getContextPath() + "/StudentViewServlet");

	}

}
