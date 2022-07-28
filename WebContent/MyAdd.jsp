<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.BikeBecho.pojo.Bike" %>
<%@ page import="com.BikeBecho.Dao.BikeDaoImpl" %>
 <%@ page import="java.util.List" %>
  <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyAdds</title>
<link href="ListStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include><br><br><br>
<%
String username=(String)session.getAttribute("username");
String email=(String)session.getAttribute("username");
List<Bike> list=new ArrayList<>();
BikeDaoImpl bDao=new BikeDaoImpl();
list=bDao.getBikeByEmail(email);
%>

<%for(Bike b:list)
	{
	%>
<div id="wrapper">



<div id="imgdiv">
<img alt="bikeImage" src="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=1" height="110px" width="110px">
</div>
<aside>
<span>Company : <%=b.getBikeManufacturerName()%><br></span>
<span>Model : <%=b.getBikeModel()%><br></span>
Price :<%=b.getPrice()%>$<br>
date of post :<%=b.getDatePosted()%><br>
<%if(username!=null){ %>
<a href="BikeServlet?operation=edit&bId=<%=b.getBikeId()%>">EDIT|</a>
<a href="BikeServlet?operation=delete&bId=<%=b.getBikeId()%>">DELETE</a>
<%} %>
</aside>
</div>
<%} %>



<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>