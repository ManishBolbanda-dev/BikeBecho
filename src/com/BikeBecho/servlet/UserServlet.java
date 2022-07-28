package com.BikeBecho.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BikeBecho.Dao.UserDaoImpl;
import com.BikeBecho.pojo.User;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String operation=request.getParameter("operation");
		User u;
		UserDaoImpl uDao=new UserDaoImpl();
		boolean flag;
		if(operation!=null && operation.equals("edit"))
		{
			HttpSession session=request.getSession();
			int uId=Integer.parseInt(request.getParameter("uId"));
		     u=uDao.getUserById(uId);
			session.setAttribute("userObj",u);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateProfile.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String operation=request.getParameter("operation");
		User u;
		UserDaoImpl uDao=new UserDaoImpl();
		boolean flag;
		if(operation!=null && operation.equals("addUser"))
		{
			String name=request.getParameter("name");
			String city=request.getParameter("city");
			String mobile=request.getParameter("mobile");
			String email=request.getParameter("email");
			String pass=request.getParameter("pass");
			u=new User(name,city,mobile,email,pass);
			
			flag=uDao.addUser(u);
			if(flag)
			{
				request.setAttribute("status", "<b> Your account has been created Successfully!!please Login.</b>");
			    RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			    rd.forward(request, response);
				//response.sendRedirect("Sucess.html");
			}
			else
			{
				response.sendRedirect("Failure.html");
			}
		}
		
		else if(operation!=null && operation.equals("updateUser"))
		{
			int uId=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("Name");
			String city=request.getParameter("city");
			String mobile=request.getParameter("mobile");
			String email=request.getParameter("email");
			String pass=request.getParameter("pass");
			u=new User(name,city,mobile,email,pass);
			u.setUserId(uId);
			
			flag=uDao.updateUser(u);
			
			if(flag)
			{
				//response.sendRedirect("Sucess.html");
				HttpSession session=request.getSession();
				session.invalidate();
				request.setAttribute("status","<b>Your Account has been Updated Succefully!!kindly Login Again</b>");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				
			}
			else
			{
				response.sendRedirect("Failure.html");
			}
		}
		
	}

}



