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
	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
	<form method="get" action="hello">
	<h1>CALCULATOR</h1>
	First number:
	<input type="text" name="txtfno"/><br/>
	Second number:
    	<input type="text" name="txtsno"/><br/>
    	select the operation:
    	<br/>
    	<input type="radio" name="operation" value="add">Addition
    	<input type="radio" name="operation" value="sub">Subtraction
    	<input type="radio" name="operation" value="mul">Multiplition
    	<input type="radio" name="operation" value="div">Divison<br/>

    	<input type="submit" value="calculate"/>
    	<input type="reset" value="reset"/>





</body>
</html>