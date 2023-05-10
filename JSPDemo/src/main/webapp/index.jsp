<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Random,java.io.*"%>
<%@page import="java.util.*" %>
<%@ include file="Demoinclude.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>

<%
Random random=new Random();
int number=random.nextInt(10000);
out.println("<br>");
%>
<%="Random number is"+number %>
</h1>

	<% out.println(2*5);%>
	<%-- scriplet tag --%>
	<%
	out.println("welcome krati");
	String name=request.getParameter("username");
	out.println("welcome "+name);
	out.println("<br>");
	%>

	<%--Declaration tag--%>
	<%!
	int num1=10;
	int num2=50;
	String name="Krati Tare";
	public int sum()
	{

	return num1+num2;
	}
	%>

	<%="Sum is::"+sum()%>
    <p>Current Date And Time  is: <%=new Date()%></p>


</body>
</html>
