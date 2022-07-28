<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ page import="com.BikeBecho.pojo.Bike" %>    
<%@ page import="com.BikeBecho.pojo.User" %>    
<%@ page import="com.BikeBecho.Dao.UserDaoImpl" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BikeDetails</title>
<link href="ExploreStyle.css" type="text/css" rel="stylesheet">
<script src="jquery.min.js"></script>
<script type="text/javascript">

function changeToImg1(id){
	
	var imageToShow=document.getElementById("fullImg");
	imageToShow.src="ImageServlet?bikeId="+id+"&imageNum=1"
}
function changeToImg2(id){
	
	var imageToShow=document.getElementById("fullImg");
	imageToShow.src="ImageServlet?bikeId="+id+"&imageNum=2"
}
function changeToImg3(id){
	
	var imageToShow=document.getElementById("fullImg");
	imageToShow.src="ImageServlet?bikeId="+id+"&imageNum=3"
}

</script>


</head>
<body style="background-color:white;">
<jsp:include page="Header.jsp"></jsp:include>
<%Bike b=(Bike)session.getAttribute("exploreBikeObj"); %>
<%UserDaoImpl uDao=new UserDaoImpl(); %>
<%User u=uDao.getUserByEmail(b.getEmail());%>



<br><br><br><br>
<div id="imgViewer">
<center> <img id="fullImg" alt="bikeImage" src="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=1" >
 </center>
 
</div>
<div>
<img id="img1" alt="bikeImage" src="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=1" width="50px" height="50px" onclick="changeToImg1(<%=b.getBikeId()%>);">
 <img class="icon" id="img2" alt="img" src="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=2" width="50px" height="50px" onclick="changeToImg2(<%=b.getBikeId()%>);">


<img class="icon" id="img3" alt="img" src="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=3" width="50px" height="50px" onclick="changeToImg3(<%=b.getBikeId()%>);">
</div>
<%-- <div id="imgCollection">
 <a href="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=1"><img class="icon" alt="img" src="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=1" width="50px" height="50px"></a>
  <a href="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=2"><img class="icon" alt="img" src="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=2" width="50px" height="50px"></a>
  <a href="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=3"><img class="icon" alt="img" src="ImageServlet?bikeId=<%=b.getBikeId()%>&imageNum=3" width="50px" height="50px"></a>
 
 </div> --%>
<div id="bikeDetails" class="specDiv"><center><b>Bike Details</b></center><br><br>
<table align="center">
<tr><td>Bike Manufaturer:</td><td><%=b.getBikeManufacturerName()%></td></tr>
<tr><td>Bike Model:</td><td><%=b.getBikeModel()%></td></tr>
<tr><td>Bike Model:</td><td><%=b.getDatePosted()%></td></tr>
<tr><td>Bike Model:</td><td><%=b.getYear()%></td></tr>
<tr><td>Bike Model:</td><td><%=b.getKmDriven()%></td></tr>
<tr><td>Bike Model:</td><td><%=b.getPrice()%></td></tr>
<tr><td>Bike Model:</td><td><%=b.getDocumentsAvailable()%></td></tr>
<tr><td>Bike Model:</td><td><%=b.getBikeCondition()%></td></tr>
<tr><td>Bike Model:</td><td><%=b.getCity()%></td></tr>
<tr><td>Bike Model:</td><td><%=b.getDescription()%></td></tr>
<tr><td>Sellers email:</td><td><%=b.getEmail()%></td></tr>

</table>





</div>

<div id="sellerDetails" class="specDiv">
<br>
<center><b>Sellers Details</b></center><br><br>

<table align="center">
<tr><td>Sellers Name:</td><td><%=u.getUserName()%></td></tr>
<tr><td>Sellers city:</td><td><%=u.getUserCity()%></td></tr>
<tr><td>Sellers Mobile No.:</td><td><%=u.getUserMobile()%></td></tr>
<tr><td>Sellers Email-Id:</td><td><%=u.getUserEmail()%></td></tr>
</table>

</div>



<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>