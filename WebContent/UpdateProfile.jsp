<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.BikeBecho.pojo.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<br><br><br><br>
<%User u=(User)session.getAttribute("userObj"); %>
<fieldset>
<legend><b>Add User Details</b></legend>


<form action="UserServlet" method="post">
<input type="hidden" name="operation" value="updateUser">
<table style="cell-padding:10px;">

<tr><td><label>Id</label></td>
<td><input type="text" name="id" value="<%=u.getUserId()%>" readonly> </td></tr>

<tr><td><label>Name</label></td>
<td><input type="text" name="Name" value="<%=u.getUserName()%>"> </td></tr>

<tr><td><label>City</label></td>
<td><input type="text" name="city" value="<%=u.getUserCity()%>"> </td></tr>

<tr><td><label>Mobile</label></td>
<td><input type="text" name="mobile" value="<%=u.getUserMobile()%>"> </td></tr>

<tr><td><label>Email</label></td>
<td><input type="text" name="email" value="<%=u.getUserEmail()%>"> </td></tr>

<tr><td><label>password</label></td>
<td><input type="text" name="pass" value="<%=u.getUserPassword()%>"> </td></tr>


<tr><td><input type="submit" value="UPDATE" style="background-color:blue;"></td>
<td><input type="reset" value="clear"></td></tr>
</table>
</form>
</fieldset>>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>