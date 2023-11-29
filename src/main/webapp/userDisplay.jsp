 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/header.jsp"%>


<div id="sub_content">

    <form class="row g-3 mt-3 ms-2" method="post" action="/StudentRegisteration/UserSearchServlet">
        
        <div class="col-auto">
            <label for="inputPassword2" class="visually-hidden">User Name</label>
            <input type="text" class="form-control" id="inputPassword2" name="name" placeholder="User Name">
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">Search</button>
        </div>
        
        <div class="col-auto">
            <button type="button" class="btn btn-secondary" onclick="location.href = 'userRegister.jsp';">Add</button>
        </div>
        <div class="col-auto">
        </div>
    </form>

    <table class="table table-striped" id="stduentTable">
        <thead>
            <tr>
                <th scope="col">No</th>
                <th scope="col">User Name</th>
                <th scope="col">Email</th>
                <c:if test="${not empty sessionScop.admin}">
            
                <th scope="col">Action</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${requestScope.users}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1 }</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <c:if test="${not empty sessionScope.admin}">
                    <td>
                        <button type="button" class="btn btn-danger mb-3" data-bs-toggle="modal" data-bs-target="#exampleModal${loop.index}">Delete</button>
                        <div class="modal fade" id="exampleModal${loop.index}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">User Deletion</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <h5 style="color: rgb(127, 209, 131);">Are you sure you want to delete ${user.name}?</h5>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-success col-md-2" data-bs-dismiss="modal" onclick="document.getElementById('deleteForm${loop.index}').submit();">Ok</button>
                                        <form id="deleteForm${loop.index}" action="UserDeleteServlet" method="post">
                                            <input type="hidden" name="id" value="${user.id}">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="../layout/footer.jsp"%>

 