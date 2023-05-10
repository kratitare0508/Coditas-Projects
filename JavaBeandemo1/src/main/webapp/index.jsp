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
<form action="welcome.jsp" method="post">
Enter id:
<input type="text" name="id"><br>
Enter fname:
<input type="text" name="fname"><br>
Enter lname:
<input type="text" name="lname"><br>
<input type="submit" value="submit">
<input type="reset" value="reset">
</form>


</body>
</html>
