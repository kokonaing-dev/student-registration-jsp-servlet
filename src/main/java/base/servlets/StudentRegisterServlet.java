package base.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import base.daos.CourseDao;
import base.daos.EnrollDao;
import base.daos.StudentDao;
import base.models.Course;
import base.models.Student;

@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentRegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CourseDao dao = new CourseDao();
		List<Course> courses = dao.getAllCourse();
		request.setAttribute("courses", courses);
		request.getRequestDispatcher("/studentRegister.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String education = request.getParameter("education");
		String [] courses = request.getParameterValues("course");
		String filename = null ;
		
		System.out.println("name "+ name + " " + "dob "+ dob + " "+"gender "+gender + " "+"phone "+phone +
				" "+" education "+ education + " courses " + courses );

//		String uploadPath = "E:/StudentRegisteration/src/main/webapp/assets/img";
//		
//		if(ServletFileUpload.isMultipartContent(request)) {
//			try {
//				List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory())
//						.parseRequest(new ServletRequestContext(request));
//				
//				for(FileItem item :	items ) {
//					if(!item.isFormField()) {
//						filename = new File(item.getName()).getName();
//						item.write( new File(uploadPath + File.separator + filename));
//					}
//				}
//			} catch (FileUploadException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		System.out.println(filename + " is .. name of photo");
//		
		Student stud = new Student(name,dob,gender,phone,education,filename);
		System.out.println(stud);
		
		StudentDao dao = new StudentDao();
		int studId = dao.createStudent(stud);
		System.out.println("Student id : " + studId);
		
		System.out.println("courses : "+ courses);
		
		//for inserting enroll table
		EnrollDao edao = new EnrollDao();
		edao.enrollStudentInCourses(studId, courses);
		
		System.out.println(stud);
		
		System.out.println("success");
		
		
		
		response.sendRedirect(request.getContextPath() + "/StudentViewServlet");
		
	}
}