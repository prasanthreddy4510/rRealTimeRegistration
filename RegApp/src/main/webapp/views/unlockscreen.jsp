<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>

<script type="text/javascript">

function validatePwds(){
	var newPwd=$('#newPwd').val();
	var confirmPwd=$('#confirmPwd').val();
	if(newPwd!=confirmPwd){
		$('#errid').text("New password and confirm password must and should be same");
		return false;
		}
	return true;
}

</script>
</head>
<body>
<font color="red"><span id="errid"></span></font><span id="errid"></span><br/>
Your registered email is:
<table>
<form:form action="/saveUnlock" modelAttribute="unlockAcc" method="post">


         
          <tr>
				<td><form:input path="email" value="${email}" readonly="true" /></td>
			</tr>
           <tr>
				<td>Temporary Password:</td>
				<td><form:password path="tempPwd" /></td>
			</tr>
			<tr>
				<td>New password:</td>
				<td><form:password path="newPwd" /></td>
			</tr>
			<tr>
				<td>Confirm password:</td>
				<td><form:password path="confimPwd" />
				 
				</td>
			</tr>
			<tr>
				<td><input type="reset" value="reset"></td>
				<td><input type="submit" value="unlock" onclick="javascript:return validatePwds()"></td>
			</tr>


</form:form>
</table>
</body>
</html>