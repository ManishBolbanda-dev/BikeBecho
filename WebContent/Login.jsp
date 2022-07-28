<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>

<br><br><br><br>

<%String status=(String)request.getAttribute("status");
out.print(status);
%>
<fieldset>
<legend>Login</legend>
<form action="LoginServlet" method="post">
<input type="hidden" name="operation" value="login">
<table>
<tr><td><input type="radio" name=type value="user">User</td>
<td><input type="radio" name=type value="admin">Admin</td></tr>
<tr>
<td><label>UserEmail</label></td>
<td><input type="text" name="email"> </td></tr>
<tr><td><label>Password</label></td>
<td><input type="text" name="pass"></td></tr>

<tr><td><input type="submit" value="LogIn"></td>

<td><a href="AddUser.jsp">SignUp</a></td>
</tr>
</table>
</form>
</fieldset>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>