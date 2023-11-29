<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Add your CSS links here -->
<link rel="stylesheet" href="assets/css/test.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Add your JavaScript links here -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js">
</script>

<title>Student Registration Project</title>
</head>
<body>
	<!-- Header section -->
	<div id="testheader">
		<div class="container">
			<div class=row>
				<div class="col-md-5 ">
					<a href="#"><h3>Student Registration</h3></a>
				</div>
				<div class="col-md-6">
					 <c:if test="${not empty sessionScope.user}">
        
				<p>User: <a href="/StudentRegisteration/UserUpdateServlet?id=${sessionScope.user.id}"> ${sessionScope.user.name}  </a> </p>
			</c:if>
			
			<c:if test="${not empty sessionScope.admin}">
        
				<p>Admin: <a href="/StudentRegisteration/UserUpdateServlet?id=${sessionScope.admin.id}"> ${sessionScope.admin.name}  </a> </p>
			</c:if>
					<p>
						Current Date :
						<%-- Use Java code to get the current date and format it --%>
						<% SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); %>
						<%= dateFormat.format(new Date()) %>
					</p>
				</div>
				
<%-- 			 <c:if test="${not empty sessionScope.user || not empty sessionScope.user}">
 --%>				
				<div class="col-md-1">
					<input type="button" class="btn-basic" id="lgnout-button"
						value="Log Out" onclick="location.href='/StudentRegisteration/LogoutServlet'">
				</div>
<%-- 			</c:if>
 --%>				
			</div>
		</div>
	</div>

	<!-- Navigation section -->
	<div class="container">
		<div class="sidenav">
        
        <button class="dropdown-btn" > Class Management </button>
        
          <div class="dropdown-container">
          <a href="/StudentRegisteration/CourseRegisterServlet">Course Registration </a>
          <a href="/StudentRegisteration/StudentRegisterServlet">Student Registration </a>
          <a href="/StudentRegisteration/StudentViewServlet">Student Search </a>
        </div>
        <a href="/StudentRegisteration/UserViewServlet">Users Management</a>
      </div>
		<div class="main_contents">
			<!-- Main content section starts here -->