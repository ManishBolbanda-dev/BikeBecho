<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.BikeBecho.pojo.Bike" %>
    <%@ page import="com.BikeBecho.pojo.User" %>
     <%@ page import="com.BikeBecho.Dao.UserDaoImpl" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Bike1</title>

<link href="ListStyle.css" rel="stylesheet" type="text/css"/>
<script>

</script>
</head>
<body >
<%
UserDaoImpl uDao=new UserDaoImpl();
User us=new User();
%>
<%
String username=(String)session.getAttribute("username");
String admin=(String)session.getAttribute("admin");
%>
              <%if(username!=null)
            	   {
            	  us=uDao.nameofUser(username);
            	   }
            	   %>
            	   
<div class="fixed-header" style="background-color:#EC7063;" >
        <div class="container">
            <nav>
                <a href="BikeServlet">Home</a>
                <a href="About.html">About</a>
                <%if(username==null)
            	   {
            	   %> 
            	   <a href="Login.jsp">Login</a>
                <%} %>
               <%if(username!=null)
            	   {
            	   %>
            	   <a href="addBike.jsp">post new Add</a>
                <a href="WishListServlet">My WishList</a>
                <a href="BikeServlet?operation=myAddList">My Ads</a>
                <%} %>
                <%if(username!=null || admin!=null) 
                {
                %>
                <a href="LoginServlet">Logout</a>
                <%} %>
                <%if(admin!=null)
            	   {
            	   %>
            	   <a href="UserServlet">show all user</a>
            	   <%} %>
            </nav>
        </div>
 <div id="searchbar"><form action="BikeServlet" method="post">
        <input type="hidden" name="operation" value="search">
        <input type="text" placeholder="Search bike name" name="searchBox" height="100%"><br>
        <input type="text" placeholder="price range From" name="start">-
           <input type="text" placeholder="price range Upto" name="end">
        <input type="submit" value="SEARCH"></form>
        <% if(username!=null)
        {%> 
        <div id="user" style="float:right; background-color:white;color:black;
     border-radius: 10px; width:200px;  height:30px;">hi,<a id="nameInHeader" href="UserServlet?operation=edit&uId=<%=us.getUserId()%>"><b><%=us.getUserName()%></b></a></div>
        <%} %>
     </div>
    </div>

<body>

</body>
</html>