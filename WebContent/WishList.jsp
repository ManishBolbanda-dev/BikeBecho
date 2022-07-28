<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
     <%@ page import="com.BikeBecho.pojo.WishList" %>
          <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WishList</title>
<link href="ListStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<br><br><br>
<%List<WishList> wList=(List<WishList>)session.getAttribute("wishListObjName"); %>

<%for(WishList w:wList)
	{
	%>
	<br>
	
<div id="wrapper">



<div id="imgdiv">
<img alt="bikeImage" src="ImageServlet?bikeId=<%=w.getBikeId()%>" height="110px" width="110px">
</div>
<aside>
<span>Company : <%=w.getWishListId()%><br></span>
<span>Model : <%=w.getBikeName()%><br></span>
Price :<%=w.getPrice()%>$<br>
<a href="WishListServlet?operation=delete&wId=<%=w.getWishListId()%>"><button>Delete</button></a>

</aside>
</div>
<%} %>





 <div class="fixed-footer">
        <div class="container">Copyright &copy; 2016 Your Company</div>        
    </div>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>