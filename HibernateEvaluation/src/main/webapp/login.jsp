<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->

<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">

<body>

 <div class="container">

  <div class="card">
   <div class="card-body">
    <form action="login" >



  <h1> LOGIN</h2>
     <div class=" form-group row">
      <label for="email" class="col-sm-2 col-form-label">email
      </label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="email"
        placeholder="Enter user email">
      </div>
     </div>

     <div class="form-group row">
      <label for="password" class="col-sm-2 col-form-label">Password</label>
      <div class="col-sm-7">
       <input type="password" class="form-control" name="password"
        placeholder="Enter Password">
      </div>
     </div>

     <button type="submit" class="btn btn-primary">Submit</button>

    </form>
   </div>
  </div>
 </div>
</body>
</html>