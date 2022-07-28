package com.BikeBecho.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BikeBecho.Dao.WishListDaoImpl;
import com.BikeBecho.pojo.WishList;



@WebServlet("/WishListServlet")
public class WishListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
    public WishListServlet()
    {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		WishListDaoImpl wDao=new WishListDaoImpl();
		String email=(String)session.getAttribute("username");
		String operation=request.getParameter("operation");
		int bId;
		WishList w;
		boolean flag;
		if(operation!=null && operation.equals("addToWishList"))
		{
			bId=Integer.parseInt(request.getParameter("bId"));
			w=new WishList(bId,email);
			flag=wDao.addToWishList(w);
			if(flag)
			{
				RequestDispatcher rd=request.getRequestDispatcher("BikeList1.jsp");
				rd.include(request, response);
			}
			else
			{
				response.sendRedirect("Failure.html");
			}
			
		}
		else if(operation!=null && operation.equals("delete"))
		{
			int wishListId=Integer.parseInt(request.getParameter("wId"));
			flag=wDao.deleteWishListById(wishListId);
			if(flag)
			{
				RequestDispatcher rd=request.getRequestDispatcher("WishList.jsp");
				rd.include(request, response);
			}
			else
			{
				response.sendRedirect("Failure.html");
			}
		}
		else
		{
			java.util.List<WishList> wList=wDao.showWishList(email);
			session.setAttribute("wishListObjName", wList);
			RequestDispatcher rd=request.getRequestDispatcher("WishList.jsp");
			rd.forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
	}

}
