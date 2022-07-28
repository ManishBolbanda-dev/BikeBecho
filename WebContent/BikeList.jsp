<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    
    <%@ page import="com.BikeBecho.pojo.Bike" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Bike</title>
</head>
<body>

<%List<Bike> bList=(List<Bike>)session.getAttribute("bikeList"); %>

<table>
<tr><th>image</th>
<th>Company</th>
<th>Model</th>
<th>Price</th>
<th>date posted</th>
<th>desc</th>
<th>explore</th>
</tr>

<%for(Bike b:bList)
	{
	%>
<tr>
<td><img alt="bikeImage" src="ImageServlet?bikeId=<%=b.getBikeId()%>" height="80px" width="80px"></td>
<td><%=b.getBikeManufacturerName()%></td>
<td><%=b.getBikeModel()%></td>
<td><%=b.getPrice()%></td>
<td><%=b.getDatePosted()%></td>
<td><%=b.getDescription()%></td>
<td><a href="">Expl</a></td>
</tr>

<%} %>

</table>


</body>
</html>