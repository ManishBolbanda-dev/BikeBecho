<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import="com.BikeBecho.pojo.Bike" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Bike</title>
<style>
fieldset { 
  display: block;
  margin-left: 300px;
  margin-right: 400px;
  padding-top: 0.35em;
  padding-bottom: 0.625em;
  padding-left: 0.75em;
  padding-right: 0.75em;
  border: 2px groove (internal value);
}
.error{
color:red;
}
</style>

</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<br><br><br>
<%Bike b=(Bike)session.getAttribute("bikeObj"); %>
<fieldset>
<legend><b>Update Bike Details</b></legend>
<form action="BikeServlet" method="post" enctype="multipart/form-data">
<input type="hidden" name="operation" value="updateBike">
<table style="cell-padding:10px;">

<tr><td><label>Bike ID</label></td>
<td><input type="text" name=bId value=<%=b.getBikeId() %> readonly ></td></tr>

<tr><td><label>Bike Manufacturers Name</label></td>
<td><input type="text" name=bmName value=<%=b.getBikeManufacturerName() %> > </td></tr>

<tr><td><label>Bike Model</label></td>
<td><input type="text" name=bModel value=<%=b.getBikeModel() %>> </td></tr>

<tr><td><label>date of post</label></td>
<td><input type="text" name=dop value=<%=b.getDatePosted() %> readonly> </td></tr>

<tr><td><label>year of purchase</label></td>
<td><input type="text" name=year value=<%=b.getYear() %>> </td></tr>

<tr><td><label>Kilimeters Driven</label></td>
<td><input type="text" name=kmDriven value=<%=b.getKmDriven() %>> </td></tr>

<tr><td><label>Price</label></td>
<td><input type="text" name=price value=<%=b.getPrice() %>> </td></tr>

<tr><td><label>Documents Available</label></td>
<td><input type="text" name=docs value=<%=b.getDocumentsAvailable() %>> </td></tr>

<tr><td><label>Bike Condition</label></td>
<td><input type="text" name=cond value=<%=b.getBikeCondition() %>> </td></tr>

<tr><td><label>City</label></td>
<td><input type="text" name=city value=<%=b.getCity() %>> </td></tr>

<tr><td><label>Description</label></td>
<td><textarea rows="5" cols="50" name="desc" placeholder="describe"></textarea> </td></tr>

<tr><td><label>Bike Image1</label></td>
<td><input type="file" name="img1"> </td></tr>

<tr><td><label>Bike Image2</label></td>
<td><input type="file" name="img2"> </td></tr>

<tr><td><label>Bike Image3</label></td>
<td><input type="file" name="img3"> </td></tr>


<tr><td><input type="submit" value="SUBMIT"></td>
<td><input type="reset" value="clear"></td></tr>
</table>
</form>
</fieldset>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>