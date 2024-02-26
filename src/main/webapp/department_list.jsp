<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Department List</title>
</head>
<body>
<h2>All Departments</h2>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Area</th>
    <th>Address</th>
    <th>Price</th>
    <th>Image</th>
    <th>User Name</th>
    <th>Phone Number</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="department" items="${allDepartments}">
    <tr>
      <td>${department.id}</td>
      <td>${department.nameDepartment}</td>
      <td>${department.area}</td>
      <td>${department.address}</td>
      <td>${department.price}</td>
      <td>${department.imageUrl}</td>
      <td>${department.user.username}</td>
      <td>${department.user.numberPhone}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="add_department.jsp">Add Department</a>
</body>
</html>
