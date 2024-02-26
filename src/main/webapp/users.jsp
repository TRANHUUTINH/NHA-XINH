<%@ page import="com.example.department_search_manager.ennity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Welcome ${user.getUserName()}</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="home.jsp">Home</a></li>
        </ul>
        <ul class="nav navbar-nav">
            <li><a href="user_departments.jsp">Phòng của bạn</a></li>
        </ul>
    </div>
</nav>


<div class="container">
    <div class="row">
        <div class="jumbotron text-center" style="
    padding-top: 0px;
    padding-bottom: 0px;
    padding-right: 0px;
    padding-left: 0px;
">
            <h2>Xin Chào ${user.getLastName()} </h2>
    </div>

        </div>
        <div class="col-md-6">
            <table class="table table-bordered">
                <tr>
                    <th>Username</th>
                    <td>${user.getUserName()}</td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td>${user.getPassword()}</td>
                </tr>
                <tr>
                    <th>First Name</th>
                    <td>${user.getFirstName()}</td>
                </tr>
                <tr>
                    <th>Last Name</th>
                    <td>${user.getLastName()}</td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>${user.getEmail()}</td>
                </tr>
                <tr>
                    <th>Phone</th>
                    <td>${user.getNumberPhone()}</td>
                </tr>
            </table>
        </div>
        <div class="col-md-6">
            <form action="/user?action=update?id=${user.getiD()}" method="post">
                <% if (request.getAttribute("errorMessage") != null) { %>
                <div>${errorMessage}</div>
                <% } %>
                <input type="hidden" name="action" value="update">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" value="${user.getUserName()}">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="text" class="form-control" id="password" name="password" value="${user.getPassword()}">
                </div>
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${user.getFirstName()}">
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${user.getLastName()}">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="${user.getEmail()}">
                </div>
                <div class="form-group">
                    <label for="numberPhone">Phone</label>
                    <input type="text" class="form-control" id="numberPhone" name="numberPhone" value="${user.getNumberPhone()}">
                </div>
                <button type="submit" class="btn btn-success">Update</button>
                <c:if test="${not empty updateSuccess}">
                    <p>Thông tin người dùng đã được cập nhật thành công.</p>
                </c:if>
            </form>

            <form action="/user" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="userID" value="${user.iD}">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </div>
    </div>
</div>
