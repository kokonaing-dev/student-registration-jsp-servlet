<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/header.jsp"%>

<div id="sub_content">
	<form action="/StudentRegisteration/StudentDetailServlet" method="post">

		<h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Details</h2>


		<input type="hidden" class="form-control" id="id" name="id"
			value="${stud.id }">

		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="name" class="col-md-2 col-form-label">Name</label>
			<div class="col-md-4">
				<input type="text" class="form-control" id="name" name="name"
					value="${stud.name }">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="dob" class="col-md-2 col-form-label">DOB</label>
			<div class="col-md-4">
				<input type="date" class="form-control" id="dob" name="dob"
					value="${stud.dob }">
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
				<input type="text" class="form-control" id="phone" name="phone"
					value="${stud.phone }">
			</div>
		</div>
		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="education" class="col-md-2 col-form-label">Education</label>
			<div class="col-md-4">
				<select class="form-select" aria-label="Education" id="education"
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

				<c:forEach items="${requestScope.courses}" var="course">
					<div class="form-check-inline col-md-2">
						<input class="form-check-input" type="checkbox" name="course"
							id="gridRadios1" value="${course.id}"> <label
							class="form-check-label" for="gridRadios1">
							${course.name} </label>
					</div>
				</c:forEach>

			</div>
		</fieldset>
		<!-- <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="name" class="col-md-2 col-form-label">Photo</label>
                <div class="col-md-4">
                    <input type="file" class="form-control" id="name">
                </div>
            </div> -->

		<div class="row mb-4">
			<div class="col-md-4"></div>





				<div class="col-md-4">

					<button type="submit" class="btn btn-secondary">

						<span>Update</span>
					</button>
				</div>

		



			<c:if test="${not empty sessionScope.admin}">


				<div class="col-md-4">

					<button type="submit" class="btn btn-secondary">

						<span>Back</span>
					</button>
				</div>

			</c:if>


		</div>
	</form>

	<button type="button" class="btn btn-danger mb-3"
		data-bs-toggle="modal" data-bs-target="#exampleModal${loop.index}">Delete</button>
	<div class="modal fade" id="exampleModal${loop.index}" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">User Deletion</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<h5 style="color: rgb(127, 209, 131);">Are you sure you want
						to delete ${stud.name}?</h5>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success col-md-2"
						data-bs-dismiss="modal"
						onclick="document.getElementById('deleteForm${loop.index}').submit();">Ok</button>
					<form id="deleteForm${loop.index}"
						action="/StudentRegisteration/StudentDeleteServlet" method="post">
						<input type="hidden" name="id" value="${stud.id}">
					</form>
				</div>
			</div>
		</div>
	</div>

</div>

<%@ include file="../layout/footer.jsp"%>


