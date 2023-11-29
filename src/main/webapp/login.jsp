<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets/css/test.css">
<title> Student Registration Project </title>
</head>
<body class="login-page-body"> 
  
   				
   
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h1>Welcome!</h1>
            <p>${requestScope.msg}</p>
          </div>
        </div>
        <form class="login-form" action="/StudentRegisteration/LoginServlet" method="post">
          <input type="text" name="email" placeholder="Email" />
          <input type="password" name="password" placeholder="Password"/>
          <button>login</button>
          <p class="message">Not registered? <a href="/StudentRegisteration/UserRegisterServlet">Create an account</a></p>
        </form>
      </div>
    </div>
</body>

</html>