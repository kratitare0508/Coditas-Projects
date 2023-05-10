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
	<h1>Hello World!</h1>
	<form method="get" action="Update">

      <label for="name">Name:</label>
      <input type="text" name="firstname" value="<%=request.getAttribute("firstname")%>">
      <br>
      <label for="email">Email:</label>
      <input type="text" name="email" value="<%=request.getAttribute("email")%>">
      <br>
      <label for="city">Pass:</label>
      <input type="text" name="city" value="<%=request.getAttribute("city")%>">
      <br>
       <label for="phone">Phoneno:</label>
            <input type="text" name="phoneno" value="<%=request.getAttribute("phoneno")%>">
            <br>
      <input type="submit" value="Edit">
    </form>





	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
