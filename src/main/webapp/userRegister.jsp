<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/header.jsp"%>



<div id="sub_content">

	<form action="/StudentRegisteration/UserRegisterServlet" method="post">

		<h2 class="col-md-6 offset-md-2 mb-5 mt-4">User Registration</h2>
		
		        <p>${requestScope.msg}</p>
		


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
			<label for="email" class="col-md-2 col-form-label">Email</label>
			<div class="col-md-4">
				<input type="email" class="form-control" id="email" name="email"
					placeholder="user123@gmail.com">
			</div>
		</div>

		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="password" class="col-md-2 col-form-label">Password</label>
			<div class="col-md-4">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="user123">
			</div>
		</div>

		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="" class="col-md-2 col-form-label"> </label>
			<div class="col-md-4">
				<div id="error-message" class="text-danger"></div>

			</div>
		</div>

		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="confirmPassword" class="col-md-2 col-form-label">Confirm
				Password</label>
			<div class="col-md-4">
				<input type="password" class="form-control" id="confirmPassword"
					placeholder="user123">
			</div>
		</div>

		<div class="row mb-4">
			<div class="col-md-2"></div>
			<label for="userRole" class="col-md-2 col-form-label">User
				Role</label>
			<div class="col-md-4">
				<select class="form-select" aria-label="Education" id="userRole"
					name="role">
					<option selected value="Admin">Admin</option>
					<option value="User">User</option>
				</select>
			</div>
		</div>

		<div class="row mb-4">
			<div class="col-md-4"></div>

			<div class="col-md-6">


				<button type="submit" class="btn btn-secondary col-md-2"
					data-bs-toggle="modal" data-bs-target="#exampleModal">Add</button>
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
									Succesfully !</h5>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-success col-md-2"
									data-bs-dismiss="modal">Ok</button>

							</div>
						</div>
					</div>
				</div>

			</div>
	</form>
</div>


<script>
    document.addEventListener('DOMContentLoaded', function () {
        var passwordField = document.getElementById('password');
        var confirmPasswordField = document.getElementById('confirmPassword');
        var errorMessageElement = document.getElementById('error-message');
        var form = document.querySelector('form');

        confirmPasswordField.addEventListener('input', function () {
            if (confirmPasswordField.value !== passwordField.value) {
                // Display an error message
                errorMessageElement.innerHTML = 'Passwords do not match!';
            } else {
                // Clear the error message if passwords match
                errorMessageElement.innerHTML = '';
            }
        });

        form.addEventListener('submit', function (event) {
            if (confirmPasswordField.value !== passwordField.value) {
                // Prevent the form from submitting if passwords do not match
                event.preventDefault();
                // Display an error message
                errorMessageElement.innerHTML = 'Passwords do not match!';
            }
        });
    });
</script>




<%@ include file="../layout/footer.jsp"%>