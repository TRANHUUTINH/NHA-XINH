<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Department</title>
</head>
<body>
<h2>Add Department</h2>
<form action="departments" method="post">
    <input type="hidden" name="action" value="add">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" required><br>
    <label for="area">Area:</label><br>
    <input type="text" id="area" name="area" required><br>
    <label for="address">Address:</label><br>
    <input type="text" id="address" name="address" required><br>
    <label for="price">Price:</label><br>
    <input type="number" id="price" name="price" step="0.01" required><br>
    <label for="image_url">Image URL:</label><br>
    <input type="text" id="image_url" name="image_url" required><br>
    <button type="submit">Add</button>
</form>
<a href="departments">Back to Department List</a>
</body>
</html>
