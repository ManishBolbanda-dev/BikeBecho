package com.BikeBecho.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.BikeBecho.Dao.BikeDaoImpl;
import com.BikeBecho.pojo.Bike;


@WebServlet("/BikeServlet") 
@MultipartConfig(maxFileSize=16777215)
public class BikeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public BikeServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BikeDaoImpl bDao=new BikeDaoImpl();
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("username");
		String operation=request.getParameter("operation");
		int bId;
		boolean flag;
		if(operation!=null && operation.equals("delete"))
		{
			bId=Integer.parseInt(request.getParameter("bId"));
			flag=bDao.deleteBikeById(bId);
			if(flag)
			{
				email=(String)session.getAttribute("username");
				List<Bike> bList=bDao.getBikeByEmail(email);
				session.setAttribute("addList", bList);
				RequestDispatcher rd=request.getRequestDispatcher("MyAdd.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("Failure.html");
			}
			
		}
		else if(operation!=null && operation.equals("edit"))
		{
			bId=Integer.parseInt(request.getParameter("bId"));
			Bike b=bDao.getBikeByid(bId);
			session.setAttribute("bikeObj", b);
			RequestDispatcher rd=request.getRequestDispatcher("updateBike.jsp");
			rd.forward(request, response);
		}
		
		else if(operation!=null && operation.equals("myAddList"))
		{
		    email=(String)session.getAttribute("username");
			List<Bike> bList=bDao.getBikeByEmail(email);
			session.setAttribute("addList", bList);
			RequestDispatcher rd=request.getRequestDispatcher("MyAdd.jsp");
			rd.forward(request, response);
		}
		else if(operation!=null && operation.equals("explore"))
		{
			bId=Integer.parseInt(request.getParameter("bId"));
			Bike b=bDao.getBikeByid(bId);
			session.setAttribute("exploreBikeObj", b);
			RequestDispatcher rd=request.getRequestDispatcher("Explore.jsp");
			rd.forward(request, response);

		}
		else //to show list of bike
		{
		List<Bike> bList=bDao.getAllBike();
		session.setAttribute("bikeList", bList);
		RequestDispatcher rd=request.getRequestDispatcher("BikeList1.jsp");
		rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String operation=request.getParameter("operation");
		HttpSession session=request.getSession();
		Bike b;
		boolean flag;
		BikeDaoImpl bDao=new BikeDaoImpl();
		
		if(operation!=null && operation.equals("addBike"))
		{
			String bmname=request.getParameter("bmName");
			String bModel=request.getParameter("bModel");
			String date=request.getParameter("dop");
			String year=request.getParameter("year");
			int km=Integer.parseInt(request.getParameter("kmDriven"));
			Double price=Double.parseDouble(request.getParameter("price"));
			String docs=request.getParameter("docs");
			String cond=request.getParameter("cond");
			String city=request.getParameter("city");
			String desc=request.getParameter("desc");
			Part p1=request.getPart("img1");
			Part p2=request.getPart("img2");
			Part p3=request.getPart("img3");
			InputStream img1=p1.getInputStream();
			InputStream img2=p2.getInputStream();
			InputStream img3=p3.getInputStream();
			String uName=request.getParameter("username");
		    b=new Bike(bmname,bModel,date,year,km,price,docs,cond,city,desc,img1,img2,img3);
			b.setEmail(uName);
			flag=bDao.addBike(b);

			if(flag)
			{
				request.setAttribute("status", "<b>Data Added Successfully!!<b>");
				
			}
			else
			{
				response.sendRedirect("Failure.html");
			}
			
		}
		
		else if(operation!=null && operation.equals("updateBike"))
		{
			int id=Integer.parseInt(request.getParameter("bId"));
			String bmname=request.getParameter("bmName");
			String bModel=request.getParameter("bModel");
			String date=request.getParameter("dop");
			String year=request.getParameter("year");
			int km=Integer.parseInt(request.getParameter("kmDriven"));
			Double price=Double.parseDouble(request.getParameter("price"));
			String docs=request.getParameter("docs");
			String cond=request.getParameter("cond");
			String city=request.getParameter("city");
			String desc=request.getParameter("desc");
			Part p1=request.getPart("img1");
			Part p2=request.getPart("img2");
			Part p3=request.getPart("img3");
			InputStream img1=p1.getInputStream();
			InputStream img2=p2.getInputStream();
			InputStream img3=p3.getInputStream();
			
			
			b=new Bike(bmname,bModel,date,year,km,price,docs,cond,city,desc,img1,img2,img3);
			b.setBikeId(id);
			flag=bDao.updateBike(b);
			if(flag)
			{
				response.sendRedirect("Sucess.html");
			}
			else
			{
				response.sendRedirect("Failure.html");
			}
			
		}
		else if(operation!=null && operation.equals("search"))
		{
			Double start=0.0,end=0.0; String search="";
			try
			{
				search=search+request.getParameter("searchBox");
			}
			 catch(Exception e)
			{
				 search="";
			}
			
			 
			try
			{
				 
				start=Double.parseDouble(request.getParameter("start"));
				 end=Double.parseDouble(request.getParameter("end"));
			}
			 catch(Exception e)
			 {
				 start=0.0;end=0.0;
			}

			List<Bike> bList=bDao.getListBySearch(search,start,end);
			session.setAttribute("bikeList", bList);
			RequestDispatcher rd=request.getRequestDispatcher("BikeList1.jsp");
			rd.forward(request, response);
		}
		else //to show list of bike
		{
		List<Bike> bList=bDao.getAllBike();
		session.setAttribute("bikeList", bList);
		RequestDispatcher rd=request.getRequestDispatcher("BikeList1.jsp");
		rd.include(request, response);
		}
		
		
	}

}
