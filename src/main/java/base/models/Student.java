package base.models;

import java.util.Arrays;

public class Student {
	
	private int id ;
	private String name ;
	private String dob ;
	private String gender ;
	private String phone ;
	private String education ;
	private String photo ;
	
	//multipartFile 
	
	private String [] courses ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	
	
	public Student(int id, String name, String dob, String gender, String phone, String education, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.education = education;
		this.photo = photo;
	}


	public Student(String name, String dob, String gender, String phone, String education , String photo) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.education = education;
		this.photo = photo;

	}

	
	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", phone=" + phone
				+ ", education=" + education + ", photo=" + photo + ", courses=" + Arrays.toString(courses) + "]";
	}


}
