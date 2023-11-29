package base.models;

public class Course {
	
	private int id ;
	private String course_code;
	private String name ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Course() {
		super();
	}
	public Course(String course_code, String name) {
		super();
		this.course_code = course_code;
		this.name = name;
	}
	
	

}
