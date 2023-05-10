<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	//<h1>Hello World!</h1>
	<form action="login">
	Enter username:
	<input type="text" name="uname"></br>
	Enter password:
	<input type="password" name="pwd"></br>

	</form>
	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
