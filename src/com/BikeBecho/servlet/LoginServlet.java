package com.BikeBecho.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BikeBecho.Dao.LoginDaoImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet()
    {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession();
		session.invalidate(); 
		request.setAttribute("status","<b>Logged Out Succefully!!</b>");
		
		RequestDispatcher rd=request.getRequestDispatcher("BikeServlet");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		HttpSession session=request.getSession();
		LoginDaoImpl lDao=new LoginDaoImpl();
		PrintWriter out=response.getWriter();
		String operation=request.getParameter("operation");
		String accType=request.getParameter("type");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		boolean flag;
		
		if(operation!=null && operation.equals("login"))
		{
			if(accType.equals("user"))
			{
				flag=lDao.userLogin(email, pass);
				if(flag)
				{
					session.setAttribute("username",email);
					request.setAttribute("status","<b>You have logged in Successfully!!</b>");
					RequestDispatcher rd=request.getRequestDispatcher("BikeServlet");
					rd.forward(request, response);
				}
				else
				{
					out.println("<b>you have Entered Wrong Credentials!!plz try again!");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.include(request,response);
				}
			}
			else
			{
				flag=lDao.adminLogin(email, pass);
				if(flag)
				{
					session.setAttribute("adminname",email);
					request.setAttribute("status","<b>You have logged in Successfully!!</b>");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{
					out.println("<b>you have Entered Wrong Credentials!!plz try again!");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.include(request,response);
				}
			}
		}
		else if(operation!=null && operation.equals("changePassword"))
		{
			String newPass=request.getParameter("newPass"); //change password code for user
			flag=lDao.userLogin(email, pass);
			if(flag)
			{
				flag=lDao.userChangePassword(email, newPass);
				if(flag)
				{
					session.invalidate(); //to drop session invalidate() is used
					request.setAttribute("status","<b>Password changed Succefully!!</b>");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("status","<b>Password is Not changed !</b>");
					RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				request.setAttribute("status", "you are not logged in yet!!operation failed");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
		}
		
	}

}
