<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Departments</title>
</head>
<body>
<h1>User Departments</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Area</th>
        <th>Address</th>
        <th>Price</th>
        <th>Image</th>
    </tr>
    <c:forEach items="${departments}" var="department">
        <tr>
            <td>${department.iD}</td>
            <td>${department.nameDepartment}</td>
            <td>${department.area}</td>
            <td>${department.address}</td>
            <td>${department.price}</td>
            <td>
                <img src="${department.imageUrl}" alt="Department Image" width="100px" height="100px">
            </td>
        </tr>
        <a href="home.jsp">Home</a>
    </c:forEach>
</table>
</body>
</html>
