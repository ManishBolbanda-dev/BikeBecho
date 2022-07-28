<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<br><br><br><br>
<%=exception %>
<br>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>