<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../layout/header.jsp" %>
    <div id="sub_content">
    
    
    
    <form action= "CourseRegisterServlet" method="post">

        <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Course Registration</h2>
        
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="course_code" class="col-md-2 col-form-label">Course</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="course_code" name="course_code" placeholder="COU001">
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="name" class="col-md-2 col-form-label">Name</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="name" name="name" placeholder="Java Web Development">
            </div>
        </div>
      

            <div class="col-md-4"></div>

            <div class="col-md-6">
               
 <button type="submit" class="btn btn-secondary col-md-2"
  data-bs-toggle="modal" data-bs-target="#exampleModal">Add</button>
                
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Course Registration</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h5 style="color: rgb(127, 209, 131);">Registered Successfully !</h5>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-success col-md-2" data-bs-dismiss="modal">Ok</button>
                               
                            </div>
                        </div>
                    </div>
            </div>

        </div>
        </form>
    </div>
<%@ include file="../layout/footer.jsp" %>