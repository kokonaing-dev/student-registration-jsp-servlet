<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layout/header.jsp"%>


<div id="sub_content">

	<form action="/StudentRegisteration/StudentRegisterServlet"
		method="post" ><!-- enctype="multipart/form-data" -->

		<h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Registration</h2>


		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="text" class="col-md-2 col-form-label">Name</label>
			<div class="col-md-4">
				<input type="text" class="form-control" id="text" name="name"
					placeholder="your name">
			</div>
		</div>


		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="dob" class="col-md-2 col-form-label">DOB</label>
			<div class="col-md-4">
				<input type="date" class="form-control" id="dob" name="dob">
			</div>
		</div>

		<fieldset class="row mb-4">
			<div class="col-md-2"></div>
			<legend class="col-form-label col-md-2 pt-0">Gender</legend>
			<div class="col-md-4">
				<div class="form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="gridRadios1" value="Male" checked> <label
						class="form-check-label" for="gridRadios1"> Male </label>
				</div>
				<div class="form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						id="gridRadios2" value="Female"> <label
						class="form-check-label" for="gridRadios2"> Female </label>
				</div>

			</div>
		</fieldset>

		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="phone" class="col-md-2 col-form-label">Phone</label>
			<div class="col-md-4">
				<input type="tel" class="form-control" id="phone" name="phone">
			</div>
		</div>

		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="education" class="col-md-2 col-form-label">Education</label>
			<div class="col-md-4">
				<select class="form-select" aria-label="education" id="education"
					name="education">
					<option selected value="Bachelor of Information Technology">Bachelor
						of Information Technology</option>
					<option value="Diploma in IT">Diploma in IT</option>
					<option value="Bachelor of Computer Science">Bachelor of
						Computer Science</option>
				</select>
			</div>
		</div>

		<fieldset class="row mb-4">
			<div class="col-md-2"></div>
			<legend class="col-form-label col-md-2 pt-0">Courses</legend>


			<div class="col-md-4">
				<c:if test="${not empty requestScope.courses}">
					<c:forEach items="${requestScope.courses}" var="course">
						<div class="form-check-inline col-md-2">
							<input class="form-check-input" type="checkbox" name="course"
								id="gridRadios1" value="${course.id}"> <label
								class="form-check-label" for="gridRadios1">
								${course.name} </label>
						</div>
					</c:forEach>
				</c:if>
			</div>

		</fieldset>


		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="image" class="col-md-2 col-form-label">Photo</label>
			<div class="col-md-4">
				<input type="file" class="form-control" id="image" name="file"
					accept="image/*">
			</div>
		</div>

		<div class="row mb-4">
			<div class="col-md-4"></div>

			<div class="col-md-4">
				<button type="submit" class="btn btn-secondary col-md-2"
					data-bs-toggle="modal" data-bs-target="#exampleModal">Add
				</button>
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Student
									Registration</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<h5 style="color: rgb(127, 209, 131);">Registered
									Successfully !</h5>
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-success col-md-2"
									data-bs-dismiss="modal">Ok</button>

							</div>
						</div>
					</div>
				</div> 
			</div>


		</div>

	</form>
</div>


<%@ include file="../layout/footer.jsp"%>


