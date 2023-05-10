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
	<jsp:useBean id="student" class="com.Student" scope="application">
	<jsp:setProperty property="*" name="student"/>


	Id is:
	<jsp:getProperty property="id" name="student"/>
  firstName is:
  <jsp:getProperty property="fname" name="student"/>
  lastName is:
  <jsp:getProperty property="lname" name="student"/>
 </jsp:useBean>


</body>
</html>
