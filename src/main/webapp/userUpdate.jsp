<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/header.jsp" %>


    <div id="sub_content">
        <form action="/StudentRegisteration/UserUpdateServlet" method="post">

        <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Your Profile</h2>
        
         <input type="hidden" class="form-control" id="email" name="id" value="${user.id}">
         
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="text" class="col-md-2 col-form-label">Name</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="name" name="name" value="${user.name}">
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="email" class="col-md-2 col-form-label">Email</label>
            <div class="col-md-4">
                <input type="email" class="form-control" id="email" name="email" value="${user.email}">
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="Password" class="col-md-2 col-form-label">Password</label>
            <div class="col-md-4">
                <input type="Password" class="form-control" id="name" name="password" value="${user.email}">
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="confirmPassword" class="col-md-2 col-form-label">Confirm Password</label>
            <div class="col-md-4">
                <input type="Password" class="form-control" id="confirmPassword" value="09090293">
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="userRole" class="col-md-2 col-form-label">User Role</label>
            <div class="col-md-4">
                <select class="form-select" aria-label="Education" id="userRole" name="role">
                    <option selected value="Admin">Admin</option>
                    <option value="User">User</option>
                </select>
            </div>
        </div>
        
        <div class="row mb-4">
        
        <!-- i delete something here / need to recovery that -->
        
                <button type="submit" class="btn btn-success col-md-2" data-bs-toggle="modal" data-bs-target="#exampleModal">Update</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">User Update</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                               
                               <h5 style="color: rgb(127, 209, 131);">Successfully Updated !</h5>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-success col-md-2" data-bs-dismiss="modal">Ok</button>
                               
                            </div>
                        </div>
                    </div>
            </div>
           <button type="button" class="btn btn-secondary col-md-2" onclick="goBack()">
    Back
</button>

<script>
    function goBack() {
        window.history.back();
    }
</script>

        </div>
        
        </form>
    </div>

<%@ include file="../layout/footer.jsp" %>


