<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    
    <%@ page import="com.BikeBecho.pojo.Bike" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<link href="ListStyle.css" rel="stylesheet" type="text/css"/>
<style>
#wrapper:hover{
      border: 3px solid #2E86C1;
      background-color:#FDEDEC;
      transform:scale(1.1);
   
    }
</style>
<script>
function explore(id)
{
	window.location="BikeServlet?operation=explore&bId="+id;
	}
</script>
</head>
<body style="background-color:#2C3E50;">
<br>
	<br>
	<br>
	
<jsp:include page="Header.jsp"></jsp:include>
<%List<Bike> bList=(List<Bike>)session.getAttribute("bikeList"); %>
<%String username=(String)session.getAttribute("username"); %>
<%for(Bike b:bList)
	{
	%>
	<br>
	
<div id="wrapper" onclick="explore(<%=b.getBikeId()%>)">



<div id="imgdiv">
<img alt="bikeImage" src="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=1" height="110px" width="110px">
</div>
<aside>
<span>Company : <%=b.getBikeManufacturerName()%><br></span>
<span>Model : <%=b.getBikeModel()%><br></span>
Price :<%=b.getPrice()%>$<br>
date of post :<%=b.getDatePosted()%><br>
Seller's email :<%=b.getEmail()%><br>
<%if(username!=null){ %>
<a href="WishListServlet?operation=addToWishList&bId=<%=b.getBikeId()%>">Add to WishList</a>
<%} %>
</aside>
</div>
<%} %>





 <div class="fixed-footer">
        <div class="container">Copyright &copy; 2019 Developed & Designed By :<b>Manish Bolbanda</b> </div>        
    </div>

</body>
</html>