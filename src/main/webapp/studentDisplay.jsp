<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../layout/header.jsp"%>

<div id="sub_content">
      <!-- <form class="row g-3 mt-3 ms-2">
        <div class="col-auto">
          <label for="staticEmail2" class="visually-hidden">studentID</label>
          <input type="text"  class="form-control" id="staticEmail2" placeholder="Student ID">
        </div>
        <div class="col-auto">
          <label for="inputPassword2" class="visually-hidden">studentName</label>
          <input type="text" class="form-control" id="inputPassword2" placeholder="Student Name">
        </div>
        <div class="col-auto">
            <label for="inputPassword2" class="visually-hidden">Course</label>
            <input type="text" class="form-control" id="inputPassword2" placeholder="Course">
          </div>
        <div class="col-auto">
          <button type="submit" class="btn btn-success mb-3">Search</button>
        </div>
        <div class="col-auto">
          <button type="submit" class="btn btn-secondary mb-3">Reset</button>
        </div>
      </form> -->
<div>
      <table class="table table-striped" id="stduentTable">
        <thead>
          <tr>
            <th scope="col">#</th>
<!--             <th scope="col">Student ID</th>
 -->            <th scope="col">Name</th>
            
            <th scope="col">Details</th>
          </tr>
        </thead>
        <tbody>
        
        <c:forEach items="${requestScope.students}" var="stud" varStatus="loop">
          <tr>
            <th scope="row">${loop.index+1}</th>
<%--             <td>${stud.id }</td>
 --%>            <td>${stud.name}</td>
<%--             <td><img src="assets/css/img/${stud.photo}"/></td>
 --%>            <td>
            	<button type="button" class="btn btn-success" onclick="location.href = 'StudentDetailServlet?id=${stud.id}';">See More</button>
            </td>
          </tr>
          </c:forEach>
          
        </tbody>
      </table>
    </div>
    </div>


<%@ include file="../layout/footer.jsp"%>


