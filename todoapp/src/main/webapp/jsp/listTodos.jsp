<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 06-04-2024
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<title>Todos List</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to Todos Project</h1>
		<h3>Your todos are </h3>
		<table class="table">
			<thead>
			<tr>
				<th>Id</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-info">Update</a></td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
