<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<br><br><br><br>
<fieldset>
<legend><b>Add Your Details</b></legend>


<form action="UserServlet" method="post">
<input type="hidden" name="operation" value="addUser">
<table style="cell-padding:10px;">

<tr><td><label>Name</label></td>
<td><input type="text" name="name"> </td></tr>

<tr><td><label>City</label></td>
<td><input type="text" name="city"> </td></tr>

<tr><td><label>Mobile</label></td>
<td><input type="text" name="mobile"> </td></tr>

<tr><td><label>Email</label></td>
<td><input type="text" name="email" placeholder="prefer your gmail id"> </td></tr>

<tr><td><label>password</label></td>
<td><input type="text" name="pass"> </td></tr>


<tr><td><input type="submit" value="SUBMIT"></td>
<td><input type="reset" value="clear"></td></tr>
</table>
</form>
</fieldset>
<jsp:include page="Footer.jsp"></jsp:include>


</body>
</html>