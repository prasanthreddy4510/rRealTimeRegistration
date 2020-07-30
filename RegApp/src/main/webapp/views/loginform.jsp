<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>${succMsg}</p>
<p>${errorMsg}</p>

<form:form action="/validate" modelAttribute="login" method="post">
  <table>
  <tr>
    <td>Email Id:</td>
    <td><form:input path="email"/></td> 
   </tr>
   <tr>
     <td>Password:</td>
     <td><form:password path="pwd"/></td>
   </tr>
   <tr>
     <td><input type="reset" value="reset"></td>
     <td><input type="submit" value="login"></td>
   </tr>
  </table><br>
  
</form:form>
<a href="http://localhost:8086/reg">Sign Up</a><br>
<a href="http://localhost:8086/load">Forgot Password</a>
</body>
</html>